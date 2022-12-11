package lesson11.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Messenger {
    private static final String EXIT_ACTION = "0";
    private static final String REGISTER_USER_ACTION = "1";
    private static final String SELECT_USER_ACTION = "2";
    private static final String WRITE_MESSAGE_ACTION = "3";
    private static final String READ_MESSAGE_ACTION = "4";
    private static final String DELETE_USER_ACTION = "5";
    private static final String PRINT_HELP_ACTION = "6";
    private static final String BACK_TO_MENU = "back";
    private static final String NEXT_MESSAGE = "[Nn][Ee][Xx][Tt]";
    private ArrayList<User> users = new ArrayList<>();
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private User selectedUser = new User();

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public void selectOption() throws IOException {
        printHelp();
        while (true) {
            printSelectUser();
            String inputOptions = enterOption();
            switch (inputOptions) {
                case REGISTER_USER_ACTION -> registerUser();
                case SELECT_USER_ACTION -> selectUser();
                case WRITE_MESSAGE_ACTION -> writeMessage();
                case READ_MESSAGE_ACTION -> readMessage();
                case DELETE_USER_ACTION -> deleteUser();
                case PRINT_HELP_ACTION -> printHelp();
                case EXIT_ACTION -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid option number!");
            }
        }
    }

    private void beginMessenger() throws IOException {
        System.out.print("Register a new user for the messenger to work(Enter the name of yhe new User) : ");
        String nameUser = bufferedReader.readLine();
        getUsers().add(new User(nameUser));
        setSelectedUser(getUsers().get(0));
        System.out.println("User successfully added!");

        checkForUser();
        selectOption();
    }

    private void checkForUser() throws IOException {
        if (getUsers().isEmpty()) {
            System.out.println("\nNo users available(register a new user)!");
            registerUser();
            setSelectedUser(getUsers().get(0));
        }
    }

    private String enterOption() throws IOException {
        System.out.print("Enter the options number(for help, enter the number 6): ");
        return bufferedReader.readLine();
    }

    private void printSelectUser() {
        if (getSelectedUser().getUserName() == null) {
            System.out.println("\nThe user is not selected!");
        } else {
            System.out.println("\nSelected user: " + getSelectedUser().getUserName());
        }
    }

    private void printHelp() {
        System.out.println("""
                Available options:
                1. Register a new user.
                2. Select a registered user.
                3. Write a message.
                4. Read a message(-s).
                5. Delete a user.
                6. Help.
                0. Exit.""");
    }

    private void printUserList() {
        for (int i = 0; i < getUsers().size(); i++) {
            System.out.println((i + 1) + ". " + getUsers().get(i).getUserName());
        }
    }

    private void registerUser() throws IOException {
        System.out.print("Enter the name of the user you want to add: ");
        String nameUser = bufferedReader.readLine();
        getUsers().add(new User(nameUser));
        System.out.println("User successfully added!");
    }

    private void selectUser() throws IOException {
        printUserList();
        System.out.print("Select a user: ");
        int numberUser = selectUserFromList();
        if (getSelectedUser() != getUsers().get(numberUser)) {
            setSelectedUser(getUsers().get(numberUser));
        } else {
            System.out.println("This user is already selected!");
        }
    }

    private int selectUserFromList() throws IOException {
        String numberList = bufferedReader.readLine();
        while (!numberList.matches("\\d+") || Integer.parseInt(numberList) - 1 > getUsers().size()) {
            System.out.print("Invalid user number! Retry! : ");
            numberList = bufferedReader.readLine();
        }
        return Integer.parseInt(numberList) - 1;
    }

    private void writeMessage() throws IOException {
        printUserList();
        System.out.print("Select the number user you want to send the massage to: ");
        int numberUser = selectUserFromList();
        System.out.print("Enter the text of the message: ");
        String message = bufferedReader.readLine();
        getSelectedUser().writeMessage(message, getUsers().get(numberUser));
    }

    private void readMessage() throws IOException {
        System.out.println("You have " + getSelectedUser().getCountMessages() + " unread messages!");
        while (getSelectedUser().getCountMessages() != 0) {
            System.out.print("To read each one, write \"next\" or write \"back\": ");
            String input = bufferedReader.readLine();
            if (input.equalsIgnoreCase(BACK_TO_MENU)) {
                return;
            } else if (!input.matches(NEXT_MESSAGE)) {
                System.out.println("Invalid!");
            } else {
                getSelectedUser().readMessage();
            }
        }
    }

    private void deleteUser() throws IOException {
        printUserList();
        System.out.print("Select the number user you want to delete: ");
        int numberUser = selectUserFromList();
        if (getSelectedUser() == getUsers().get(numberUser)) {
            setSelectedUser(new User());
        }
        getUsers().remove(numberUser);
        System.out.println("User successfully deleted!");
    }

    public static void main(String[] args) {
        Messenger messenger = new Messenger();
        try {
            messenger.beginMessenger();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
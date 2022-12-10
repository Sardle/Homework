package lesson11.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Messenger {
    private ArrayList<User> users = new ArrayList<>();
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private boolean exit = true;
    private User selectedUser = new User();
    private boolean block = true;
    private boolean firstRegistration = true;

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public void messengerLogic() {
        try {
            if (firstRegistration) {
                startMessenger();
            }
            printHelp();
            while (exit) {
                printSelectUser();
                String inputOptions = enterOption();
                if (!block) {
                    switch (inputOptions) {
                        case "0" -> {
                            System.out.println("Bye!");
                            exit = false;
                        }
                        case "1" -> registerUser();
                        case "2" -> selectUser();
                        case "3" -> writeMessage();
                        case "4" -> readMessage();
                        case "5" -> deleteUser();
                        case "6" -> printHelp();
                        default -> System.out.println("Invalid option number!");
                    }
                } else {
                    System.out.println("\nNo users available(register a new user)!");
                    registerUser();
                    setSelectedUser(getUsers().get(0));
                    messengerLogic();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void startMessenger() throws IOException {
        System.out.print("Register a new user for the messenger to work(Enter the name of yhe new User) : ");
        String nameUser = bufferedReader.readLine();
        getUsers().add(new User(nameUser));
        setSelectedUser(getUsers().get(0));
        System.out.println("User successfully added!");
        firstRegistration = false;
        block = false;
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
        block = false;
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
            if (input.equals("back")) {
                return;
            } else if (!input.matches("next")) {
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
        if (getUsers().size() == 0) {
            block = true;
        }
    }

    public static void main(String[] args) {
        Messenger messenger = new Messenger();
        messenger.messengerLogic();
    }
}
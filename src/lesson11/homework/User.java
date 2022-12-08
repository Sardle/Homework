package lesson11.homework;

import java.util.ArrayDeque;

public class User {
    private String userName;
    private ArrayDeque<String> messages = new ArrayDeque<>();

    public int getCountMessages() {
        return getMessages().size();
    }

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public ArrayDeque<String> getMessages() {
        return messages;
    }

    public void writeMessage(String message, User user) {
        user.getMessages().addLast(message + ";name:" + getUserName());
        System.out.println("The message was successfully sent to " + user.getUserName());
    }

    public void readMessage() {
        if (getMessages().peekFirst() != null) {
            String message = getMessages().peekFirst().replaceAll(";name:" + ".*", "");
            String name = getMessages().pollFirst().replaceAll(".*" + ";name:", "");
            System.out.println("Message from " + name + " : " + message);
        }
    }
}

package leason9.homework;

import java.util.Scanner;

public class App {
    private static final String CHECK_DATA = "[A-Za-z\\d_]{1,20}";

    public static void main(String[] args) {
        registration();
    }

    public static void registration() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        try {
            if (checkLoginAndPassword(login, password, "Qwerty")) {
                System.out.println("Все верно! Вход разрешен");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean checkLoginAndPassword(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!login.matches(CHECK_DATA)) {
            throw new WrongLoginException("Неверный логин");
        } else if (!password.matches(CHECK_DATA) || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Неверный пароль");
        } else {
            return true;
        }
    }
}

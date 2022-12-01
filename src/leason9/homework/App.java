package leason9.homework;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        checkData();
    }

    public static void checkData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        try {
            if (task(login, password, "Qwerty")) {
                System.out.println("Все верно! Вход разрешен");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
    public static boolean task(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!login.matches("[A-Za-z\\d_]{1,20}")) {
            throw new WrongLoginException("Неверный логин");
        } else if (!password.matches("[A-Za-z\\d_]{1,20}") || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Неверный пароль");
        } else {
            return true;
        }
    }
}

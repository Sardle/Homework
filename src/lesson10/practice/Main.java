package lesson10.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        calculateString();
    }

    private static void task1() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Введите алфавит: ");
            String alphabet = bufferedReader.readLine()
                    .toLowerCase()
                    .replaceAll("\\s+", "");
            if (!alphabet.startsWith("a")) {
                System.out.println("Неверное начало!");
            } else if (!alphabet.endsWith("z")) {
                System.out.println("Неверное конец!");
            } else if (!alphabet.regionMatches(1, "bcdefghijklmnopqrstuvwxy", 0, 24)) {
                System.out.println("Неверная середина!");
            } else {
                System.out.println("Все окей!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void task2() {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb);
        System.out.println("charAt(1) = " + sb.charAt(1));
        sb.setCharAt(1, 'i');
        sb.setLength(2);
        System.out.println(sb);
    }

    private static void printStringInfo(String input) {
        System.out.println("String: " + input);
        System.out.println("Последний символ строки: " + input.charAt(input.length() - 1));
        System.out.println(input.endsWith("!!!") ? "Да, заканчивается на \"!!!\"" : "Нет, не заканчивается на \"!!!\"");
        System.out.println(input.startsWith("I like") ? "Да, начинается на \"I like\"" : "Нет, не начинается на \"I like\"");
        System.out.println(input.contains("Java") ? "Да, содержит подстроку \"Java\"" : "Нет, не содержит подстроку \"Java\"");
        System.out.println(input.indexOf("Java"));
        System.out.println(input.replaceAll("a", "o") + " - замена всех а на о");
        System.out.println(input.toUpperCase() + " - в аппер кейсе");
        System.out.println(input.toLowerCase() + " - в ловер кейсе");
        System.out.println(input.substring(7, 11));
    }

    private static void calculateString() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Введите первое число: ");
            String firstNumber = bufferedReader.readLine();
            System.out.print("Введите второе число: ");
            String secondNumber = bufferedReader.readLine();

            StringBuilder plus = new StringBuilder(firstNumber);
            plus.append(" + ")
                    .append(secondNumber)
                    .append(" = ")
                    .append(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));
            System.out.println(plus);

            StringBuilder minus = new StringBuilder(firstNumber);
            minus.append(" - ")
                    .append(secondNumber)
                    .append(" = ")
                    .append(Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber));
            System.out.println(minus);

            StringBuilder multiply = new StringBuilder(firstNumber);
            multiply.append(" * ")
                    .append(secondNumber)
                    .append(" = ")
                    .append(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
            System.out.println(multiply + "\n");

            plus.insert(plus.lastIndexOf("="), "равно ");
            System.out.println(plus);
            minus.insert(minus.lastIndexOf("="), "равно ");
            System.out.println(minus);
            multiply.insert(multiply.lastIndexOf("="), "равно ");
            System.out.println(multiply + "\n");

            plus.replace(plus.indexOf("+"), plus.lastIndexOf("+") + 1, "плюс");
            System.out.println(plus);
            minus.replace(minus.indexOf("-"), minus.indexOf("-") + 1, "минус");
            System.out.println(minus);
            multiply.replace(multiply.indexOf("*"), multiply.lastIndexOf("*") + 1, "умножить");
            System.out.println(multiply);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
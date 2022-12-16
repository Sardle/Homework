package lesson13.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        fillList();
        System.out.println("Initial list: " + list);
        FilterList.printAllMethods(list);
    }

    private static int enterSizeList() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("Enter the size of list: ");
            input = scanner.nextLine();
            if (!input.matches("\\d+")) {
                System.out.println("Invalid input! Try again!\n");
            }
        } while (!input.matches("\\d+"));
        return Integer.parseInt(input);
    }

    private static void fillList() {
        int sizeList = enterSizeList();
        for (int i = 0; i < sizeList; i++) {
            list.add((int) (Math.random() * 20));
        }
    }
}

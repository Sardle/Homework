package lesson13.homework;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> initialList = createList();
        System.out.println("Initial list: " + initialList);

        ArrayList<Integer> filteredList = (ArrayList<Integer>) initialList.stream()
                .distinct()
                .filter(it -> it >= 7 && it <= 17 && it % 2 == 0)
                .peek(it -> System.out.print(it + " "))
                .map(it -> it * 2)
                .filter(it -> it > 10)
                .collect(Collectors.toList());

        System.out.println("\nNumber of items in the list: " + filteredList.stream()
                .count());
        System.out.println("Arithmetic mean of the elements: " + filteredList.stream()
                .mapToDouble(it -> it)
                .average()
                .getAsDouble());
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

    private static ArrayList<Integer> createList() {
        ArrayList<Integer> list = new ArrayList<>();
        int sizeList = enterSizeList();
        for (int i = 0; i < sizeList; i++) {
            list.add((int) (Math.random() * 20));
        }
        return list;
    }
}

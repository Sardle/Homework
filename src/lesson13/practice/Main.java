package lesson13.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add((int) (Math.random() * 45));
        }
        System.out.println("Start list: " + arrayList);
        List<Integer> filteredList = arrayList.stream()
                .filter(it -> it % 2 == 0)
                .toList();
        System.out.println("Filtered list(stream): " + filteredList);
        Predicate<Integer> predicate = it -> it % 2 == 0;
        List<Integer> filteredListPredicate = arrayList.stream()
                .filter(predicate)
                .toList();
        System.out.println("Filtered list(predicate): " + filteredListPredicate);
    }

    private static Integer enterNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    private static void exampleStream() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("Mikita");
        list.add("Max");
        list.add("Arseni");
        list.add("Roma");
        list.add("Denis");
        list.add("Misha");
        System.out.println(list);
        System.out.println(list.stream()
                .filter(it -> it.startsWith("A"))
                .collect(Collectors.toList()));

        System.out.println(arrayList.stream()
                .filter(it -> it % 4 == 0)
                .map(it -> it + 10)
                .filter(it -> String.valueOf(it).matches(".*2.*"))
                .collect(Collectors.toList()));
        System.out.println(arrayList.parallelStream().sorted().collect(Collectors.toList()));
    }
}
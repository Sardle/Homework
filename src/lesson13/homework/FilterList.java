package lesson13.homework;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FilterList {
    private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        return (ArrayList<Integer>) list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private static void printEvenNumbers(ArrayList<Integer> list) {
        System.out.println("All even elements in the range from 7 to 17: " + list.stream()
                .filter(it -> it >= 7 && it <= 17 && it % 2 == 0)
                .toList());
    }

    private static ArrayList<Integer> multiplyList(ArrayList<Integer> list) {
        return (ArrayList<Integer>) list.stream()
                .map(it -> it * 2)
                .collect(Collectors.toList());
    }

    private static void printSortedList(ArrayList<Integer> list) {
        System.out.println("The first 4 elements of the sorted list: " + list.stream()
                .sorted()
                .limit(4)
                .toList());
    }

    private static ArrayList<Integer> leaveMoreTen(ArrayList<Integer> list) {
        return (ArrayList<Integer>) list.stream()
                .filter(it -> it > 10)
                .collect(Collectors.toList());
    }

    private static long getCountItemsList(ArrayList<Integer> list) {
        return list.stream()
                .count();
    }

    private static double getArithmeticMean(ArrayList<Integer> list) {
        double sum = list.stream()
                .mapToDouble(it -> it)
                .sum();
        return sum / list.size();
    }

    public static void printAllMethods(ArrayList<Integer> list) {
        System.out.println("List without duplicates: " + removeDuplicates(list));
        printEvenNumbers(list);
        System.out.println("Multiply all elements by two: " + multiplyList(list));
        printSortedList(list);
        System.out.println("Items greater than 10: " + leaveMoreTen(list));
        System.out.println("Number of items in the list: " + getCountItemsList(list));
        System.out.println("Arithmetic mean of the elements: " + getArithmeticMean(list));
    }
}

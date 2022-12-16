package lesson13.homework;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FilterList {
    private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        return (ArrayList<Integer>) list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private static ArrayList<Integer> getEvenNumbersFromRange(ArrayList<Integer> list) {
        return (ArrayList<Integer>) list.stream()
                .filter(it -> it >= 7 && it <= 17 && it % 2 == 0)
                .collect(Collectors.toList());
    }

    private static ArrayList<Integer> multiplyList(ArrayList<Integer> list) {
        return (ArrayList<Integer>) list.stream()
                .map(it -> it * 2)
                .collect(Collectors.toList());
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
        ArrayList<Integer> withoutDuplicates = removeDuplicates(list);
        System.out.println("List without duplicates: " + withoutDuplicates);

        ArrayList<Integer> onlyEvenFromRange = getEvenNumbersFromRange(withoutDuplicates);
        System.out.println("All even elements in the range from 7 to 17: " + onlyEvenFromRange);

        ArrayList<Integer> multiplyList = multiplyList(onlyEvenFromRange);
        System.out.println("Multiply all elements by two: " + multiplyList);

        ArrayList<Integer> onlyMoreTen = leaveMoreTen(multiplyList);
        System.out.println("Items greater than 10: " + onlyMoreTen);

        long countItemsList = getCountItemsList(onlyMoreTen);
        System.out.println("Number of items in the list: " + countItemsList);

        double arithmeticMean = getArithmeticMean(onlyMoreTen);
        System.out.println("Arithmetic mean of the elements: " + arithmeticMean);
    }
}

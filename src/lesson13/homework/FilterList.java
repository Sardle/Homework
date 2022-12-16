package lesson13.homework;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FilterList {
    private static ArrayList<Integer> arrayList;

    public static void setArrayList(ArrayList<Integer> arrayList) {
        FilterList.arrayList = arrayList;
    }

    private static void removeDuplicates() {
        arrayList = (ArrayList<Integer>) arrayList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("List without duplicates: " + arrayList);
    }

    private static void getEvenNumbersFromRange() {
        arrayList = (ArrayList<Integer>) arrayList.stream()
                .filter(it -> it >= 7 && it <= 17 && it % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("All even elements in the range from 7 to 17: " + arrayList);
    }

    private static void multiplyList() {
       arrayList = (ArrayList<Integer>) arrayList.stream()
                .map(it -> it * 2)
               .collect(Collectors.toList());
        System.out.println("Multiply all elements by two: " + arrayList);
    }

    private static void leaveMoreTen() {
        arrayList = (ArrayList<Integer>) arrayList.stream()
                .filter(it -> it > 10)
                .collect(Collectors.toList());
        System.out.println("Items greater than 10: " + arrayList);
    }

    private static long getCountItemsList() {
        return arrayList.stream()
                .count();
    }

    private static double getArithmeticMean() {
        double sum = arrayList.stream()
                .mapToDouble(it -> it)
                .sum();
        return sum / arrayList.size();
    }

    public static void printAllMethods(ArrayList<Integer> list) {
        setArrayList(list);

        removeDuplicates();
        getEvenNumbersFromRange();
        multiplyList();
        leaveMoreTen();

        System.out.println("Number of items in the list: " + getCountItemsList());
        System.out.println("Arithmetic mean of the elements: " + getArithmeticMean());
    }
}

package lesson12.practice;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        deleteNumber();
    }

    public static void deleteNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the numbers: ");
        String input = scanner.nextLine().replaceAll("\\D"," ").trim().replaceAll("\\s+"," ");
        String[] numbers = input.split(" ");
        HashSet<Integer> number = new HashSet<>();

        for (String s : numbers) {
            number.add(Integer.parseInt(s));
        }
        for (Integer anInt: number) {
            System.out.print(anInt + " ");
        }
    }

    public static void printEntrySet(HashMap<String, Product> map) {
        for (Map.Entry<String,Product> products : map.entrySet()) {
            System.out.println(products.getKey() + " - " + products.getValue().getPrice());
        }
    }

    public static void printKeys(HashMap<String, Product> map) {
        for (String products : map.keySet()) {
            System.out.println(products);
        }
    }

    public static void printValues(HashMap<String, Product> map) {
        for (Product products : map.values()) {
            System.out.println(products.getPrice());
        }
    }
}

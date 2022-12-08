package lesson11.practice;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter the count a seat: ");
        Scanner scanner = new Scanner(System.in);
        int countSeat = scanner.nextInt();
        Minibus minibus = new Minibus(countSeat);

        ArrayDeque<Person> people = new ArrayDeque<>();
        people.add(new Person("Max"));
        people.add(new Person("Nikita"));
        people.add(new Person("Maria"));
        people.add(new Person("Roma"));
        people.add(new Person("Igor"));
        people.add(new Person("Oleg"));
        people.add(new Person("Julia"));

        MinibusLogic.getOffMinibus(people, countSeat, minibus);
        for (Person person : minibus.getPeople()) {
            System.out.println(person);
        }
    }
}
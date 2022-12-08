package lesson11.practice;

import java.util.ArrayDeque;

public class MinibusLogic {
    public static void getOffMinibus(ArrayDeque<Person> people, int count, Minibus minibus) {
        for (int i = 0; i < count; i++) {
            if (people.peek() != null) {
                minibus.getPeople().add(people.poll());
            } else {
                System.out.println("The minibus is waiting");
                break;
            }
        }
    }
}

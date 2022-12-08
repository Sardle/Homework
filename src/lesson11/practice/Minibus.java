package lesson11.practice;

import java.util.ArrayList;

public class Minibus {
    private int countSeat;
    private ArrayList<Person> people = new ArrayList<>();

    public ArrayList<Person> getPeople() {
        return people;
    }

    public Minibus(int countSeat) {
        this.countSeat = countSeat;
    }
}

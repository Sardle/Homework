package lesson11.practice;

public class Person implements Comparable<Person> {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}

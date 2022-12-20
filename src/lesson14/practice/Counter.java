package lesson14.practice;

public class Counter {
    private volatile int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

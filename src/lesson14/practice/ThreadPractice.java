package lesson14.practice;

public class ThreadPractice {
    public static void main(String[] args) {
        counter();
    }

    public static void counter() {
        Counter counter = new Counter();
        Runnable runnable = () -> {
            synchronized (counter) {
                while (counter.getValue() != 30) {
                    counter.setValue(counter.getValue() + 1);
                    System.out.println(counter.getValue());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread.start();
        thread1.start();
        thread2.start();
    }
}

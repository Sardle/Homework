package lesson14.practice;

public class Main {
    public static void main(String[] args) {
        AppThread appThread = new AppThread();

        Thread thread = new Thread(() -> {
            for (int i = 1; i < 100; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        appThread.start();
        thread.start();
    }
}

class AppThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + "is running");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
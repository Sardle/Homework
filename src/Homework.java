import java.util.Scanner;

public class Homework {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        System.out.print("Enter a number: ");
        int input = scanner.nextInt();
        if (input % 2 == 0) {
            System.out.println("This number is even");
        } else {
            System.out.println("This number is odd");
        }
    }

    public static void task2() {
        System.out.print("Enter three numbers: ");

        int firstInput = scanner.nextInt();
        int secondInput = scanner.nextInt();
        int thirdInput = scanner.nextInt();

        int first = firstInput > 0 ? firstInput : -firstInput;
        int second = secondInput > 0 ? secondInput : -secondInput;
        int third = thirdInput > 0 ? thirdInput : -thirdInput;

        int minimum;
        if (first > third && second > third) {
            minimum = third;
        } else if (first > second && third > second) {
            minimum = second;
        } else if (second > first && third > first) {
            minimum = first;
        } else {
            minimum = first;
        }

        System.out.println("Minimum number: " + minimum);
    }

    public static void task3() {
        System.out.print("Введите число: ");
        switch (scanner.nextInt()) {
            case 1 -> System.out.println("Понедельник");
            case 2 -> System.out.println("Вторник");
            case 3 -> System.out.println("Среда");
            case 4 -> System.out.println("Четверг");
            case 5 -> System.out.println("Пятница");
            case 6 -> System.out.println("Суббота");
            case 7 -> System.out.println("Воскресенье");
            default -> System.out.println("Неизвестный день недели");
        }
    }
}

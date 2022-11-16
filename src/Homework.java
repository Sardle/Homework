import java.util.Scanner;

public class Homework {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        task1();
        task2();
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
}

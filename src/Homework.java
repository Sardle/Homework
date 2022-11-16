import java.util.Scanner;

public class Homework {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        task1();
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
}

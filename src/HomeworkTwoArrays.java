import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeworkTwoArrays {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        twoDimenToOneDimen();
    }

    public static void twoDimenToOneDimen() {
        System.out.print("Enter two numbers for the dimension of the array: ");
        int column = scanner.nextInt();
        int row = scanner.nextInt();
        int[][] twoArray = new int[column][row];
        for (int i = 0; i < twoArray.length; i++) {
            for (int j = 0; j < twoArray[i].length; j++) {
                twoArray[i][j] = random.nextInt(101);
            }
        }
        System.out.println("The resulting array:");
        for (int[] array : twoArray) {
            for (int anInt : array) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        int[] oneArray = new int[column * row];
        int index = 0;
        for (int[] array : twoArray) {
            for (int anInt : array) {
                oneArray[index] = anInt;
                index++;
            }
        }
        System.out.println("The resulting one-dimensional array: " + Arrays.toString(oneArray));
    }
}

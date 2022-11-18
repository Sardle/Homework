import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeworkTwoArrays {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        twoDimenToOneDimen();
        onlyText();
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

    public static void onlyText() {
        System.out.print("Enter three numbers for the dimension of the array: ");
        int[][][] threeArray = new int[scanner.nextInt()][scanner.nextInt()][scanner.nextInt()];
        for (int i = 0; i < threeArray.length; i++) {
            for (int j = 0; j < threeArray[i].length; j++) {
                for (int k = 0; k < threeArray[i][j].length; k++) {
                    threeArray[i][j][k] = random.nextInt(11);
                }
            }
        }
        System.out.println("The resulting array:");
        for (int[][] twoArray : threeArray) {
            for (int[] array : twoArray) {
                for (int anInt : array) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Replaced array:");
        for (int[][] twoArray : threeArray) {
            for (int[] array : twoArray) {
                for (int anInt : array) {
                    System.out.print(numbers(anInt) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static String numbers(int number) {
        return switch (number) {
            case 0 -> "zero";
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            case 10 -> "ten";
            default -> null;
        };
    }
}

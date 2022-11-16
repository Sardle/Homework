import java.util.Arrays;
import java.util.Scanner;

public class HomeworkArrays {
    public static void main(String[] args) {
        onlyEven();
    }

    public static void onlyEven() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        int arraySize = scanner.nextInt();
        while (arraySize <= 5 || arraySize > 10) {
            System.out.println("Размерность массива неверна");
            System.out.print("Повторите ввод: ");
            arraySize = scanner.nextInt();
        }

        int[] array = new int[arraySize];
        int onlyEvenNumbers = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
            if (array[i] % 2 == 0) {
                onlyEvenNumbers++;
            }
        }
        System.out.println("Введенный массив: " + Arrays.toString(array));

        if (onlyEvenNumbers == 0) {
            System.out.println("В массиве нет четных чисел");
        } else {
            int[] even = new int[onlyEvenNumbers];
            int temp = 0;
            for (int j : array) {
                if (j % 2 == 0) {
                    even[temp] = j;
                    temp++;
                }
            }
            System.out.println("Массив четных чисел: " + Arrays.toString(even));
        }
    }
}

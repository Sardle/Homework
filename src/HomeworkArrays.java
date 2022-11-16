import java.util.Arrays;
import java.util.Scanner;

public class HomeworkArrays {
    public static void main(String[] args) {
        deleteNumbers();
    }

    public static void deleteNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int delete = scanner.nextInt();
        int size = 0;
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
            if (array[i] == delete) {
                size++;
            }
        }

        if (size == 0){
            System.out.println("Нет чисел удовлетворяющих условию");
            System.out.print("Массив: " + Arrays.toString(array));
        } else {
            System.out.println("Массив до удаление всех чисел: " + Arrays.toString(array));
            int[] deleteNumbers = new int[array.length - size];
            int temp = 0;
            for (int j : array) {
                if (j != delete) {
                    deleteNumbers[temp] = j;
                    temp++;
                }
            }
            System.out.print("Массив после удаление всех чисел: " + Arrays.toString(deleteNumbers));
        }
    }
}

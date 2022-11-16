import java.util.Arrays;

public class HomeworkArrays {
    public static void main(String[] args) {
        sortingArrayOfNames();
    }

    public static void sortingArrayOfNames() {
        String[] strings = {"Nikita", "Maxim", "Matvei", "Ivan", "Igor", "Slava", "Kirill"};
        Arrays.sort(strings);
        System.out.println("Отсортированный массив имен: " + Arrays.toString(strings));
    }
}

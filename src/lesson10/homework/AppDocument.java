package lesson10.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppDocument {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        do {
            System.out.print("\nEnter the document number: ");
            try {
                input = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!Document.printInfoDocument(input));
    }
}

package leason10.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppDocument {

    public static void main(String[] args) {
        String input;
        do {
            System.out.print("\nEnter the document number: ");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                input = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!Document.printInfoDocument(input));
    }
}

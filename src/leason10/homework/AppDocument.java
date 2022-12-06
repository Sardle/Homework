package leason10.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppDocument {

    public static void main(String[] args) {
        System.out.print("Enter the document number: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = bufferedReader.readLine();
            while (!Document.printInfoDocument(input)) {
                System.out.print("\nEnter the document number: ");
                input = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

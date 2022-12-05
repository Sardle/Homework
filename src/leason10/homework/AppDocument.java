package leason10.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppDocument {

    public static void main(String[] args) {
        printInfoFromDocument();
    }

    public static void printInfoFromDocument() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Document Template: xxxx-yyy-xxxx-yyy-xyxy. " +
                    "Where \"x\" is a digit, and \"y\" is a letter of the English alphabet.\n");
            System.out.print("Enter the document number: ");
            String input = bufferedReader.readLine();
            if (!Document.checkPattern(input)) {
                System.out.println("You entered the document number incorrectly! Try again!");
                printInfoFromDocument();
            } else {
                Document.printTwoBlocksNumbers(input);
                Document.printReplaceBlocks(input);
                Document.printLetters(input);
                Document.checkAbc(input);
                Document.checkSequence(input);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

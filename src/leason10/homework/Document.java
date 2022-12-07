package leason10.homework;

public class Document {
    private static final String DOCUMENT_PATTERN = "\\d{4}-[A-z]{3}-\\d{4}-[A-z]{3}-\\d[A-z]\\d[A-z]";

    private static boolean checkPattern(String document) {
        return document.matches(DOCUMENT_PATTERN);
    }

    private static void printTwoBlocksNumbers(String document) {
        String twoBlocksNumbers = document.replaceAll("-...-\\d[A-z]\\d[A-z]", "")
                .replaceAll("-[A-z]{3}", "");
        System.out.println("\nThe first two blocks of digits: " + twoBlocksNumbers);
    }

    private static void printEntcodedNumber(String document) {
        String replaceBlocks = document.replaceAll("[A-z]{3}", "***");
        System.out.println("Replaced document number: " + replaceBlocks);
    }

    private static void printLetters(String document) {
        StringBuilder sb = new StringBuilder(document);
        String withoutNumbers = sb.delete(0, 5)
                .delete(4, 9)
                .deleteCharAt(8)
                .deleteCharAt(9)
                .replace(3, 4, "/")
                .replace(7, 8, "/")
                .replace(9, 9, "/")
                .toString()
                .toUpperCase();
        System.out.println("Letters from the document number: " + withoutNumbers);
    }

    private static void checkContainsAbc(String document) {
        if (document.toLowerCase().matches(".*abc.*")) {
            System.out.println("Yes, the document contains the sequence abc!");
        } else {
            System.out.println("No, the document does not contain the sequence abc!");
        }
    }

    private static void checkEndsWith1a2b(String document) {
        if (document.endsWith("1a2b")) {
            System.out.println("Yes, the document contains the sequence 1a2b!");
        } else {
            System.out.println("No, the document does not contain the sequence 1a2b!");
        }
    }

    public static boolean printInfoDocument(String input) {
        System.out.println("Document Template: xxxx-yyy-xxxx-yyy-xyxy. " +
                "Where \"x\" is a digit, and \"y\" is a letter of the English alphabet.");
        if (!Document.checkPattern(input)) {
            System.out.println("You entered the document number incorrectly! Try again!");
            return false;
        } else {
            Document.printTwoBlocksNumbers(input);
            Document.printEntcodedNumber(input);
            Document.printLetters(input);
            Document.checkContainsAbc(input);
            Document.checkEndsWith1a2b(input);
            return true;
        }
    }
}

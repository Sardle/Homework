import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SimCard[] simCards = new SimCard[(int) (Math.random() * 10 + 1)];
        for (int i = 0; i < simCards.length; i++) {
            simCards[i] = createSim();
        }

        Phone phone = new Phone(new MtsSimCard((int) (Math.random() * 10 + 10), "296574487"));
        for (int i = 0; i < simCards.length; i++) {
            phone.insertNewSim(simCards[i]);
            System.out.print("\nВведите номер для действия: ");
            if (i % 2 == 0) {
                phone.makeCall(scanner.nextLine());
            } else {
                phone.receiveCall(scanner.nextLine());
            }
            phone.printBalance();
        }
    }

    public static SimCard createSim() {
        int random = (int) (Math.random() * 3 + 1);
        switch (random) {
            case 1 -> {
                return new MtsSimCard((int) (Math.random() * 10 + 10), randomNumber());
            }
            case 2 -> {
                return new LifeSimCard((int) (Math.random() * 10 + 10), randomNumber());
            }
            case 3 -> {
                return new A1SimCard((int) (Math.random() * 10 + 10), randomNumber());
            }
            default -> {
                return null;
            }
        }
    }

    public static String randomNumber() {
        return String.valueOf((int) (Math.random() * 9999999 + 1000000));
    }
}

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        SimCard[] simCards = new SimCard[(int) (Math.random() * 10 + 1)];
        for (int i = 0; i < simCards.length; i++) {
            simCards[i] = createSim();
        }

        Phone phone = new Phone(new MtsSimCard((int) (Math.random() * 10 + 10), "296574487"));
        System.out.println();
        phone.printBalance();

        for (int i = 0; i < simCards.length; i++) {
            if (i % 2 == 0) {
                phone.makeCall(simCards[i]);
            } else {
                phone.receiveCall(simCards[i]);
            }
            phone.printBalance();
        }
    }

    public static SimCard createSim() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер телефона: ");
        String number = scanner.nextLine();

        int random = (int) (Math.random() * 3 + 1);
        switch (random) {
            case 1 -> {
                return new MtsSimCard((int) (Math.random() * 10 + 10), number);
            }
            case 2 -> {
                return new LifeSimCard((int) (Math.random() * 10 + 10), number);
            }
            case 3 -> {
                return new A1SimCard((int) (Math.random() * 10 + 10), number);
            }
            default -> {
                return null;
            }
        }
    }
}

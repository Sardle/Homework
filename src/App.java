import java.util.Scanner;

public class App {
    private SimCard[] simCards = new SimCard[(int) (Math.random() * 10 + 1)];
    private boolean exit = true;
    private boolean block = false;
    private SimCard oldSimCard;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        app.appSim();
    }

    public void appSim() {
        System.out.println("Данный телефон: ");
        Phone phone = new Phone(new MtsSimCard((int) (Math.random() * 10 + 10), "296574487", "1111"));

        System.out.println("Остальные сим карты: ");
        createSim();

        printInfo();

        options(phone);
    }

    private void options(Phone phone) {
        while (exit) {
            System.out.print("\nВведите номер желаемой опции: ");
            String input = scanner.nextLine();
            if (block) {
                switch (input) {
                    case "1" -> on(phone);
                    case "2" -> off(phone);
                    default -> System.out.println("\nВАШ ТЕЛЕФОН ЗАБЛОКИРОВАН! ДЕЙСТВИЕ НЕДОСТУПНО!\n");
                }
            } else if (!phone.isIncluded()) {
                switch (input) {
                    case "1" -> on(phone);
                    case "2" -> off(phone);
                    case "3" -> newSim(phone, input);
                    default -> System.out.println("\nВаш телефон выключен! Действие недоступно!\n");
                }
            } else {
                switch (input) {
                    case "1" -> on(phone);
                    case "2" -> off(phone);
                    case "3" -> newSim(phone, input);
                    case "4" -> phone.printInfoSim();
                    case "5" -> printSimCard();
                    case "6" -> call(phone);
                    case "7" -> receive(phone);
                    case "8" -> plusBalance(phone);
                    case "9" -> {
                        System.out.println("\nBye!");
                        exit = false;
                    }
                    default -> System.out.println("\nНеверный номер опции. Повторите!\n");
                }
            }
        }
    }

    private void on(Phone phone) {
        if (phone.isIncluded()) {
            System.out.println("\nТелефон и так включен включен!\n");
        } else {
            if (!phone.turnOn()) {
                block = true;
            }
        }
    }

    private void off(Phone phone) {
        if (phone.isIncluded()) {
            phone.turnOff();
            block = false;
        } else {
            System.out.println("\nТелефон и так был выключен!\n");
        }
    }

    private void newSim(Phone phone, String input) {
        printSimCard();
        System.out.print("Введите номер ячейки сим карты, которую желаете вставить: ");
        input = scanner.nextLine();
        while (!input.matches("\\d0?") || Integer.parseInt(input) > simCards.length || input.equals("0")) {
            System.out.print("Неверный номер ячейки! Повторите ввод: ");
            input = scanner.nextLine();
        }
        oldSimCard = phone.getSimCard();
        if (phone.insertNewSim(simCards[Integer.parseInt(input) - 1])) {
            simCards[Integer.parseInt(input) - 1] = oldSimCard;
        } else {
            block = true;
        }
    }

    private void call(Phone phone) {
        System.out.print("Введите номер, на которые хотите позвонить: ");
        phone.makeCall(scanner.nextLine());
        phone.printBalance();
    }

    private void receive(Phone phone) {
        System.out.print("Введите номер, с которого принимается звонок: ");
        phone.receiveCall(scanner.nextLine());
        phone.printBalance();
    }

    private void plusBalance(Phone phone) {
        System.out.print("Введите количество денег, которые вы хотите положить на телефон: ");
        int plusBalance = Integer.parseInt(scanner.nextLine());
        phone.getSimCard().setBalance(phone.getSimCard().getBalance() + plusBalance);
        phone.printBalance();
    }

    private void createSim() {
        for (int i = 0; i < simCards.length; i++) {
            simCards[i] = randomSim();
        }
    }

    private SimCard randomSim() {
        int random = (int) (Math.random() * 3 + 1);
        switch (random) {
            case 1 -> {
                return new MtsSimCard((int) (Math.random() * 10 + 10), randomNumber(), randomPin());
            }
            case 2 -> {
                return new LifeSimCard((int) (Math.random() * 10 + 10), randomNumber(), randomPin());
            }
            case 3 -> {
                return new A1SimCard((int) (Math.random() * 10 + 10), randomNumber(), randomPin());
            }
            default -> {
                return null;
            }
        }
    }

    private void printSimCard() {
        System.out.println("\nДоступные симкарты: ");
        for (int i = 0; i < simCards.length; i++) {
            System.out.println((i + 1) + ". Оператор - " + simCards[i].getOperatorName() +
                    ". Номер - " + simCards[i].getNumber() + ". Баланс - " + simCards[i].getBalance());
        }
    }

    private void printInfo() {
        System.out.println("""
                Доступные опции:
                1. Включить телефон.
                2. Выключить телефон.
                3. Вставить новую сим карту.
                4. Информация о сим карте в телефоне.
                5. Информация о доступных сим картах.
                6. Совершить звонок.
                7. Принять звонок.
                8. Положить деньги на баланс.
                9. Завершить программу.
                """);
    }

    private String randomNumber() {
        return String.valueOf((int) (Math.random() * 9999999 + 1000000));
    }

    private String randomPin() {
        return String.valueOf((int) (Math.random() * 9999 + 1000));
    }
}

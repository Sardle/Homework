package HomeworkSimCard;

import java.util.Scanner;

public class Phone {
    private SimCard simCard;
    private boolean included = true;

    public SimCard getSimCard() {
        return simCard;
    }

    public boolean isBlock() {
        return simCard.isBlock();
    }

    public void setBlock(boolean newBlock) {
        simCard.setBlock(newBlock);
    }

    public Phone(SimCard simCard) {
        this.simCard = simCard;
    }

    public boolean insertNewSim(SimCard newSimCard) {
        if (newSimCard.isBlock()){
            System.out.println("\nВАШ ТЕЛЕФОН ЗАБЛОКИРОВАН!");
            return false;
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите ПИН код: ");
            String inputSim = scanner.nextLine();
            if (newSimCard.checkPin(inputSim)) {
                this.simCard = newSimCard;
                System.out.println("\nНомер - " + newSimCard.getNumber() +
                        "\nИмя оператора - " + newSimCard.getOperatorName() +
                        "\nБаланс - " + newSimCard.getBalance());
                return true;
            } else {
                this.simCard = newSimCard;
                return invalidPin();
            }
        }
    }

    public void insertNewSimInOffPhone(SimCard newSimCard) {
        this.simCard = newSimCard;
        System.out.println("Новая сим карта вставлена в телефон!");
    }

    public void turnOff() {
        System.out.println("\nТелефон выключен");
        included = false;
    }

    public boolean turnOn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Телефон включается");
        System.out.print("Введите ПИН код: ");
        String inputSim = scanner.nextLine();

        if (simCard.checkPin(inputSim)) {
            System.out.println("\nПИН код верный! Телефон готов к использованию");
            included = true;
            return true;
        } else {
            return invalidPin();
        }
    }

    public boolean invalidPin() {
        System.out.println("Неверный ПИН код!!!");
        Scanner scanner = new Scanner(System.in);
        String inputSim;
        for (int i = 2; i >= 1; i--) {
            System.out.print("У вас осталось " + i + " попыток. Повторите ввод: ");
            inputSim = scanner.nextLine();
            if (simCard.checkPin(inputSim)) {
                System.out.println("\nПИН код верный! Телефон готов к использованию");
                included = true;
                return true;
            }
        }
        System.out.println("\nВАШ ТЕЛЕФОН ЗАБЛОКИРОВАН!");
        return false;
    }

    public void makeCall(String number) {
        simCard.makeCall(number);
    }

    public void receiveCall(String number) {
        simCard.receiveCall(number);
    }

    public void printBalance() {
        System.out.println("Баланс этой симкарты - " + simCard.getBalance());
    }

    public void printInfoSim() {
        System.out.println("\nНомер - " + simCard.getNumber() +
                "\nИмя оператора - " + simCard.getOperatorName() +
                "\nБаланс - " + simCard.getBalance());
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }

    public boolean isIncluded() {
        return included;
    }
}

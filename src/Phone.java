public class Phone {
    private SimCard simCard;

    public Phone(SimCard simCard) {
        this.simCard = simCard;
    }

    public void insertNewSim(SimCard newSimCard) {
        this.simCard = newSimCard;
        System.out.println("\nНомер - " + newSimCard.getNumber() +
                "\nИмя оператора - " + newSimCard.getOperatorName() +
                "\nБаланс - " + newSimCard.getBalance());
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
}

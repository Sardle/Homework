public class Phone {
    private SimCard simCard;

    public Phone(SimCard simCard) {
        this.simCard = simCard;
    }

    public void insertNewSim(SimCard newSimCard) {
        simCard = newSimCard;
        System.out.println("Номер - " + newSimCard.getNumber() +
                "\nИмя оператора - " + newSimCard.getOperatorName() +
                "\nБаланс - " + newSimCard.getBalance());
    }

    public void makeCall(SimCard sim) {
        simCard.makeCall(sim);
    }

    public void receiveCall(SimCard sim) {
        simCard.receiveCall(sim);
    }

    public void printBalance() {
        System.out.println("Баланс этой симкарты - " + simCard.getBalance());
    }
}

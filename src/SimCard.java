public class SimCard {
    private int balance;
    private String number;

    protected SimCard(int balance, String number) {
        this.balance = balance;
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public String getOperatorName() {
        return null;
    }

    public void makeCall(SimCard simCard) {
        if (getBalance() > 0) {
            System.out.println("Звоню на номер: " + simCard.getNumber());
        } else {
            System.out.println("Звонок запрещен. Недостаточно средств!");
        }
    }

    public void receiveCall(SimCard simCard) {
        System.out.println("Принимаю звонок с номера: " + simCard.getNumber());
    }
}

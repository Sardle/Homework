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

    public void makeCall(String number) {
        if (getBalance() > 0) {
            System.out.println("Звоню на номер: " + number);
        } else {
            System.out.println("Звонок запрещен. Недостаточно средств!");
        }
    }

    public void receiveCall(String number) {
        System.out.println("Принимаю звонок с номера: " + number);
    }
}

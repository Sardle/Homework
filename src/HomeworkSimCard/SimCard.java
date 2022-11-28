package HomeworkSimCard;

public class SimCard {
    private String pinCode;
    private int balance;
    private String number;
    private boolean block = false;

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    protected SimCard(int balance, String number, String pinCode) {
        this.balance = balance;
        this.number = number;
        this.pinCode = pinCode;
        System.out.println("ПИН код номера - " + number + ": " + pinCode);
    }

    public boolean checkPin(String inputPin) {
        return pinCode.equals(inputPin);
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

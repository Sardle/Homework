package HomeworkSimCard;

public final class A1SimCard extends SimCard {
    private boolean block = false;

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public A1SimCard(int balance, String number, String pinCode) {
        super(balance, "33" + number, pinCode);
    }

    @Override
    public String getOperatorName() {
        return "A1";
    }

    @Override
    public void makeCall(String number) {
        int price = checkCall(number) ? 1 : 3;
        if (price <= getBalance()) {
            setBalance(getBalance() - price);
            System.out.println("\nЗвоню на номер: " + number);
        } else {
            System.out.println("\nЗвоню на номер: " + number +
                    "\nЗвонок запрещен. Недостаточно средств!");
        }
    }

    @Override
    public void receiveCall(String number) {
        if (!checkCall(number)) {
            setBalance((getBalance() - 1));
        }
        System.out.println("\nПринимаю звонок с номера: " + number);
    }

    public Boolean checkCall(String number) {
        return number.matches("33.*");
    }
}
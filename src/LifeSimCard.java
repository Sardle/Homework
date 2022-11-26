public final class LifeSimCard extends SimCard {
    private boolean block = false;

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public LifeSimCard(int balance, String number, String pinCode) {
        super(balance, "44" + number, pinCode);
    }

    @Override
    public String getOperatorName() {
        return "Life";
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
        return number.matches("44.*");
    }
}
public final class A1SimCard extends SimCard {

    protected A1SimCard(int balance, String number) {
        super(balance, "33" + number);
    }

    @Override
    public String getOperatorName() {
        return "A1";
    }

    @Override
    public void makeCall(String number) {
        if (checkCall(number)) {
            call(number, 1);
        } else {
            call(number, 3);
        }
    }

    private void call(String number, int price) {
        if (getBalance() - price > 0) {
            setBalance((getBalance() - price));
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

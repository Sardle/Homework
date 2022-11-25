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
            if (getBalance() - 1 > 0) {
                setBalance((getBalance() - 1));
                System.out.println("\nЗвоню на номер: " + number);
            } else {
                System.out.println("\nЗвоню на номер: " + number +
                        "\nЗвонок запрещен. Недостаточно средств!");
            }
        } else {
            if (getBalance() - 3 > 0) {
                setBalance((getBalance() - 3));
                System.out.println("\nЗвоню на номер: " + number);
            } else {
                System.out.println("\nЗвоню на номер: " + number +
                        "\nЗвонок запрещен. Недостаточно средств!");
            }
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

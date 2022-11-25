public final class MtsSimCard extends SimCard {

    public MtsSimCard(int balance, String number) {
        super(balance, "29" + number);
    }

    @Override
    public String getOperatorName() {
        return "MTS";
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
        return number.matches("29.*");
    }
}

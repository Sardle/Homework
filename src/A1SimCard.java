public final class A1SimCard extends SimCard {

    protected A1SimCard(int balance, String number) {
        super(balance, "33" + number);
    }

    @Override
    public String getOperatorName() {
        return "A1";
    }

    @Override
    public void makeCall(SimCard simCard) {
        if (simCard instanceof A1SimCard) {
            if (getBalance() - 1 > 0) {
                setBalance((getBalance() - 1));
                System.out.println("\nЗвоню на номер: " + simCard.getNumber());
            } else {
                System.out.println("\nЗвонок запрещен. Недостаточно средств!");
            }
        } else {
            if (getBalance() - 3 > 0) {
                setBalance((getBalance() - 3));
                System.out.println("\nЗвоню на номер: " + simCard.getNumber());
            } else {
                System.out.println("\nЗвонок запрещен. Недостаточно средств!");
            }
        }
    }

    @Override
    public void receiveCall(SimCard simCard) {
        if (simCard instanceof A1SimCard) {
            System.out.println("\nПринимаю звонок с номера: " + simCard.getNumber());
        } else {
            if (getBalance() - 1 > 0) {
                setBalance((getBalance() - 1));
                System.out.println("\nПринимаю звонок с номера: " + simCard.getNumber());
            } else {
                System.out.println("\nПринять звонок нельзя. Недостаточно средств!");
            }
        }
    }
}

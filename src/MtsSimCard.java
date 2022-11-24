public final class MtsSimCard extends SimCard {

    protected MtsSimCard(int balance, String number) {
        super(balance, "29" + number);
    }

    @Override
    public String getOperatorName() {
        return "MTS";
    }

    @Override
    public void makeCall(SimCard simCard) {
        if (simCard instanceof MtsSimCard) {
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
        if (simCard instanceof MtsSimCard) {
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

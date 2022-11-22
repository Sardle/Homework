import java.util.Scanner;

public class CreditCard {
    private String accountNumber;
    private int accountStatus;

    public CreditCard(String accountNumber, int accountStatus) {
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
    }

    public void addUpAmount(int amount) {
        accountStatus += amount;
    }

    public void withdrawAmount(int amount) {
        if (amount > accountStatus || accountStatus == 0) {
            System.out.println("\nError! Insufficient funds");
        } else {
            accountStatus -= amount;
            System.out.println("Successfully");
        }
    }

    @Override
    public String toString() {
        return "Account number: " + accountNumber + "\nAccount status: $" + accountStatus + "\n";
    }

    public static void operation() {
        Scanner scanner = new Scanner(System.in);

        CreditCard cardUserMikita = new CreditCard("BY3847359NX", 5000);
        CreditCard cardUserOleg = new CreditCard("BY3454564NX", 1000);
        CreditCard cardUserJulia = new CreditCard("BY23423429NX", 10000);

        System.out.println(cardUserMikita);
        System.out.println(cardUserOleg);
        System.out.println(cardUserJulia);

        System.out.print("Enter the amount of thr operation to add: ");
        cardUserMikita.addUpAmount(scanner.nextInt());
        System.out.print("Enter the amount of thr operation to add: ");
        cardUserOleg.addUpAmount(scanner.nextInt());
        System.out.print("Enter the amount of thr operation to reduce: ");
        cardUserJulia.withdrawAmount(scanner.nextInt());

        System.out.println("\n" + cardUserMikita);
        System.out.println(cardUserOleg);
        System.out.println(cardUserJulia);
    }

    public static void main(String[] args) {
        operation();
    }
}

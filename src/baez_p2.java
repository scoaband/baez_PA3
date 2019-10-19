public class baez_p2 extends SavingsAccount{

    public static void main(String[] args) {

        // Test SavingAccount
        baez_p2 test = new baez_p2();
        double amount_1 = 2000, amount_2 = 3000;
        int percent_1 = 4, percent_2 = 5;

        System.out.println("\n\t\t Annual Interest Rate App");
        System.out.print("\n Account Balance at 4%:\n");
        // Test Annual Interest Rate App - Amount, Annual Rate 4%
        test.accountApp(amount_1, percent_1);
        test.accountApp(amount_2, percent_1);

        System.out.print("\n Account Balance at 5%:\n");
        // Test Annual Interest Rate App - Amount , Annual Rate 5%
        test.accountApp(amount_1, percent_2);
        test.accountApp(amount_2, percent_2);
    }
}

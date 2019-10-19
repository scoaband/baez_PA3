
public class SavingsAccount {

    private  double savingsBalance;
    private  double annualInterestRate;

    private void calculateMonthlyInterest(double month) {
        double monthlyInterest = ((savingsBalance * annualInterestRate) / month);
        savingsBalance += monthlyInterest;
    }

    private void savingBalance() {System.out.printf(" $%.2f\n", savingsBalance);}

    private void setBalance(double userBalance) {savingsBalance = userBalance;}

    private void modifyInterestRate(int newInterestRate){annualInterestRate = ((double)newInterestRate / 100.00);}

    public static void accountApp(double SavingAccount1, int annualRatePercent){
        final double MONTHS = 12;
        SavingsAccount app  = new SavingsAccount();
        app.setBalance(SavingAccount1);
        app.modifyInterestRate(annualRatePercent);
        for (int i = 0; i < MONTHS; ++i) {
            app.calculateMonthlyInterest(MONTHS);
        }
        System.out.print(" Saving Account = ");
        app.savingBalance();
    }
}

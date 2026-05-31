// Single Inheritance Example

class BankAccount {
    String accountHolder = "Sushank";
    double balance = 5000;

    void showBalance() {
        System.out.println(accountHolder + " has balance Rs. " + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interest = 250;

    void addInterest() {
        balance = balance + interest;
        System.out.println("Interest added: Rs. " + interest);
    }
}

public class Ques5 {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount();

        account.showBalance();
        account.addInterest();
        account.showBalance();
    }
}

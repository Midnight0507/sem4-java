public class Bank {
    public static void main(String[] args) {
        Account a = new Account();
        System.out.println(a.accHolderName + " has balance: " + a.checkBalance());
        
        Account a1 = new Account(12, "BOB", 20000);
        a1.withDraw(1000);
        a1.withDraw(250);
        a1.withDraw(200000);
        a1.Deposit(2000);
        
        System.out.println(a1.accHolderName + " has balance: " + a1.checkBalance());
        System.out.println(a1.accHolderName + " has made " + a1.Transactions() + " transactions.");
        BankTransaction.transfer(a1, a, 2000f);
        System.out.println(a.accHolderName + " has balance: " + a.checkBalance());
        System.out.println(a1.accHolderName + " has balance: " + a1.checkBalance() + "Transactions : " + a1.Transactions());
        System.out.println("Total transactions in the bank: " + BankTransaction.getTotalTransactions());
    }
}

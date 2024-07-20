class BankTransaction {
    private static int totalTransactions = 0; 
    public static void transfer(Account from, Account to, float amount) {
        if (from.checkBalance() >= amount) {
            from.withDraw(amount); 
            to.Deposit(amount); 
            totalTransactions++; 
        } else {
            System.out.println("Transfer cannot be completed: Insufficient funds");
        }
    }
    public static int getTotalTransactions() {
        return totalTransactions;
    }
}
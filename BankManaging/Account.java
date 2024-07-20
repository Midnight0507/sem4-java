public class Account {
    private int accNo;
    String accHolderName;
    private float balance;
    private int transactions;

    Account() {
        accNo = 101;
        balance = 1000;
        accHolderName = "jim";
        transactions = 0;
    }

    Account(int num, String name, float bal) {
        accNo = num;
        accHolderName = name;
        balance = bal;
        transactions = 0; 
    }

    float Transactions() {
        return transactions;
    }

    void Deposit(float amount) {
        transactions++; 
        balance += amount;
    }
    
    void withDraw(float amt) {
        if (amt < balance) {
            balance -= amt; 
            transactions++; 
        } else {
            System.out.println("Not enough funds");
        }
    }

    float checkBalance() {
        return balance;
    }
    public int getAccNo() {
        return accNo;
    }
}

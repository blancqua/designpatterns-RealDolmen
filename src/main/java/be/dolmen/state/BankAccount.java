package be.dolmen.state;

public class BankAccount {

    static final double MINIMUM_BALANCE = -2500;

    private double balance;
    private BankAccountState state = new OpenState(this);

    public void deposit(double amount) {
        state.deposit(amount);
    }

    public void withDraw(double amount) {
        state.withDraw(amount);
    }

    public void close() {
        state.close();
    }

    public double getBalance() {
        return balance;
    }

    void plus(double amount) {
        balance += amount;
    }

    void minus(double amount) {
        balance -= amount;
    }

    void setState(BankAccountState state) {
        this.state = state;
    }
}

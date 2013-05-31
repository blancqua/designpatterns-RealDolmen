package be.dolmen.state;

abstract class BankAccountState {

    protected BankAccount account;

    BankAccountState(BankAccount account) {
        this.account = account;
    }

    void close() {
        account.setState(new ClosedState(account));
    }

    abstract void deposit(double amount);
    abstract void withDraw(double amount);

}

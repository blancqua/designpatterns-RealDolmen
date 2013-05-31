package be.dolmen.state;

class ClosedState extends BankAccountState {

    ClosedState(BankAccount account) {
        super(account);
    }

    @Override
    void deposit(double amount) {
        throw new IllegalStateException("Depositing not allowed on closed bank account");
    }

    @Override
    void withDraw(double amount) {
        throw new IllegalStateException("Withdrawing not allowed on closed bank account");
    }

}

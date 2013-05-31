package be.dolmen.state;

import static be.dolmen.state.BankAccount.MINIMUM_BALANCE;

class BankruptState extends BankAccountState {

    BankruptState(BankAccount account) {
        super(account);
    }

    @Override
    void deposit(double amount) {
        account.plus(amount);

        if (account.getBalance() > 0) {
            account.setState(new OpenState(account));
        } else if (account.getBalance() > MINIMUM_BALANCE) {
            account.setState(new InDebtState(account));
        }
    }

    @Override
    void withDraw(double amount) {
        throw new IllegalStateException("Withdrawing not allowed on bankrupt bank account");
    }

}

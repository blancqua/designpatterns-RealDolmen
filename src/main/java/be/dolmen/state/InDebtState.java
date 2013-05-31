package be.dolmen.state;

import static be.dolmen.state.BankAccount.MINIMUM_BALANCE;

class InDebtState extends BankAccountState {

    InDebtState(BankAccount account) {
        super(account);
    }

    @Override
    void deposit(double amount) {
        account.plus(amount);

        if (account.getBalance() > 0) {
            account.setState(new OpenState(account));
        }
    }

    @Override
    void withDraw(double amount) {
        account.minus(amount);

        if (account.getBalance() <= MINIMUM_BALANCE) {
            account.setState(new BankruptState(account));
        }
    }

}

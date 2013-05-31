package be.dolmen.state;

import static be.dolmen.state.BankAccount.MINIMUM_BALANCE;


class OpenState extends BankAccountState {

    OpenState(BankAccount account) {
        super(account);
    }

    @Override
    void deposit(double amount) {
        account.plus(amount);
    }

    @Override
    void withDraw(double amount) {
        account.minus(amount);

        if (account.getBalance() <= MINIMUM_BALANCE) {
            account.setState(new BankruptState(account));
        } else if (account.getBalance() < 0) {
            account.setState(new InDebtState(account));
        }
    }

}

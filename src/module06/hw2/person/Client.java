package module06.hw2.person;

import module06.hw2.account.Account;

public abstract class Client {
    protected Account account = new Account();
//    private long balance;

    public long getBalance() {
        return account.balance;
    }

    public abstract boolean deposit(long sum);

    public abstract boolean withdraw(long amount);

}

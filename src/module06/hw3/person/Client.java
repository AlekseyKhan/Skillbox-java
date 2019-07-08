package module06.hw3.person;

public abstract class Client {
    //    protected Account account = new Account();
    private long balance;

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public abstract boolean deposit(long sum);

    public abstract boolean withdraw(long amount);

    protected boolean isSumValid(long sum) {
        return sum > 0;
    }

    protected boolean isSumValid(long sum, long value) {
        return sum >= value;
    }

    protected boolean printInvalidSum(long sum) {
        System.out.println("Некорректные входные данные '" + sum + "'");
        return false;
    }

}

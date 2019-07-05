package module06.hw1.bankAccount.accounts;

public class CardAccount extends BankAccount {
    private int commission = 1;

    @Override
    public boolean withdraw(long value) {
        long sum = value + (long) Math.round(value * commission / 100);
        System.out.printf("Комиссия составляет %d%%\nК списанию %d\n", commission,sum);
        return super.withdraw(sum);
    }
}

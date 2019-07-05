package module06.hw2.person;

public class Entity extends Client {
    private float withdraw_commission = 1.0f;

    @Override
    public boolean deposit(long sum) {
        if (sum >= 0) {
            System.out.println("Пополнение " + sum);
            account.balance += sum;
            return true;
        } else {
            System.out.println("Некорректные входные данные '" + sum + "'");
            return false;
        }
    }

    @Override
    public boolean withdraw(long amount) {
        if (amount >= 1000) {
            withdraw_commission = 0.5f;
        } else if (amount >= 0) {
            withdraw_commission = 1.0f;
        } else {
            System.out.println("Некорректные входные данные '" + amount + "'");
            return false;
        }

        long totalSum = amount + (long) Math.round(amount * withdraw_commission / 100);

        if (account.balance >= totalSum) {
            System.out.printf("Снятие %d. Комиссия %.1f%%. Итого к списанию - \n", amount, withdraw_commission, totalSum);
            account.balance -= totalSum;
            return true;
        } else {
            System.out.println("Недостаточно денег");
            return false;
        }
    }

}

package module06.hw2.person;

public class Entrepreneur extends Client {
    private float deposit_commission = 1.0f;

    @Override
    public boolean deposit(long sum) {
        if (sum >= 1000) {
            deposit_commission = 0.5f;
        } else if (sum >= 0) {
            deposit_commission = 1.0f;
        } else {
            System.out.println("Некорректные входные данные '" + sum + "'");
            return false;
        }

        long totalSum = sum - (long) Math.round(sum * deposit_commission / 100);
        System.out.printf("Пополнение %d. Комиссия %.1f%%. Итого к пополнению- \n", sum, deposit_commission, totalSum);
        account.balance += totalSum;
        return true;
    }

    @Override
    public boolean withdraw(long amount) {
        if (amount < 0) {
            System.out.println("Некорректные входные данные '" + amount + "'");
            return false;
        }

        if (account.balance >= amount) {
            System.out.println("Снятие " + amount);
            account.balance -= amount;
            return true;
        } else {
            System.out.println("Недостаточно денег");
            return false;
        }
    }
}

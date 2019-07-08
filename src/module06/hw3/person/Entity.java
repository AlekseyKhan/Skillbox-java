package module06.hw3.person;

public class Entity extends Client {
    private final float ONE_PERCENT = 1.0f;

    @Override
    public boolean deposit(long sum) {
        if (isSumValid(sum)) {
            System.out.println("Пополнение " + sum);
            setBalance(getBalance() + sum);
            return true;
        } else {
            return printInvalidSum(sum);
        }
    }

    @Override
    public boolean withdraw(long amount) {
        float commission;

        if (isSumValid(amount)) {
            commission = ONE_PERCENT;
        } else {
            return printInvalidSum(amount);
        }

        long totalSum = amount + (long) Math.round(amount * commission / 100);

        if (getBalance() >= totalSum) {
            System.out.printf("Снятие %d. Комиссия %.1f%%. Итого к списанию: %d\n", amount, commission, totalSum);
            setBalance(getBalance() - totalSum);
            return true;
        } else {
            System.out.println("Недостаточно денег");
            return false;
        }
    }

}

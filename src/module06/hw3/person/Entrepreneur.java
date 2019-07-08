package module06.hw3.person;

public class Entrepreneur extends Client {
    private final float ONE_PERCENT = 1.0f;
    private final float HALF_PERCENT = 0.5f;

    @Override
    public boolean deposit(long sum) {
        float commission;
        if (isSumValid(sum, 1000)) {
            commission = HALF_PERCENT;
        } else if (isSumValid(sum)) {
            commission = ONE_PERCENT;
        } else {
            return printInvalidSum(sum);
        }

        long totalSum = sum - (long) Math.round(sum * commission / 100);
        System.out.printf("Пополнение %d. Комиссия %.1f%%. Итого к пополнению: %d\n", sum, commission, totalSum);
        setBalance(getBalance() + totalSum);
        return true;
    }

    @Override
    public boolean withdraw(long amount) {
        if (!isSumValid(amount)) {
            return printInvalidSum(amount);
        }

        if (getBalance() >= amount) {
            System.out.println("Снятие " + amount);
            setBalance(getBalance() - amount);
            return true;
        } else {
            System.out.println("Недостаточно денег");
            return false;
        }
    }
}

package module06.hw3.person;

public class Individual extends Client {

    @Override
    public boolean deposit(long sum) {
        if (!isSumValid(sum)) {
            return printInvalidSum(sum);
        } else {
            System.out.println("Пополнение " + sum);
            setBalance(getBalance() + sum);
            return true;
        }
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

package module06.hw2.person;

public class Individual extends Client {

    @Override
    public boolean deposit(long sum) {
        if (sum < 0) {
            System.out.println("Некорректные входные данные '" + sum + "'");
            return false;
        } else {
            System.out.println("Пополнение " + sum);
            account.balance += sum;
            return true;
        }
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

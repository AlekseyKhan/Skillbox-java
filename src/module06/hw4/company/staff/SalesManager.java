package module06.hw4.company.staff;

public class SalesManager implements Employee {
    public static final int DEFAULT_SALARY = 15500;
    private final int INTEREST = 5;
    private long salary;
    private long totalSalary;
    private String name;

    public SalesManager() {
        this("undefined", DEFAULT_SALARY);
    }

    public SalesManager(String name, long salary) {
        this.name = name;
        this.salary = salary;
        this.totalSalary = salary;
    }

    public void calculateSalary(long monthIncome) {
        long bonus = (long) Math.round(monthIncome * INTEREST / 100);
        totalSalary = salary + bonus;
    }

    @Override
    public long getMonthSalary() {
        return totalSalary;
    }

    @Override
    public String toString() {
        return String.format("%s. Менеджер по продажам, оклад %d и плюс %d%% от результата",
                name, salary, INTEREST
        );

    }
}

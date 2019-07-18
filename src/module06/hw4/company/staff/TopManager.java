package module06.hw4.company.staff;

import module06.hw4.company.Company;

public class TopManager implements Employee {
    public static final long DEFAULT_SALARY = 50000;
    public static final long THRESHOLD_FOR_AWARD = 10000000;
    private final int INTEREST = 100;
    private long salary;
    private String name;
    private long totalSalary;

    public TopManager() {
        this("undefined", DEFAULT_SALARY);
    }

    public TopManager(String name, long salary) {
        this.name = name;
        this.salary = salary;
        this.totalSalary = salary;
    }

    public void calculateBonus(Company company) {
        if (company.getCompanyRevenue() > THRESHOLD_FOR_AWARD) {
            long bonus = (long) Math.round(salary * INTEREST / 100);
            totalSalary = salary + bonus;
        }
    }

    @Override
    public long getMonthSalary() {
        return totalSalary;
    }

    @Override
    public String toString() {
        return String.format("%s. Топ-менеджер, фиксированный оклад - %d и премия, если доход компании будет свыше %d, составляет %d%% от оклада",
                name, salary, THRESHOLD_FOR_AWARD, INTEREST
        );
    }
}

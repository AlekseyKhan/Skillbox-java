package module06.hw4.company.staff;

public class SalesManager implements Employee {
    public static final int SALARY = 15500;
    private final int INTEREST = 5;
    private long salary;
    private long totalSalary;
    private String name;

    public SalesManager() {
        this("undefined", SALARY);
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
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append(name)
                .append(". Менеджер по продажам, оклад ").append(salary)
                .append(" и плюс ").append(INTEREST)
                .append("% от результата");

        return info.toString();
//        System.out.printf(
//                "%s работает менеджером по продажам, оклад %d и плюс премия %d%% от результата\n",
//                name, salary, INTEREST
//        );

    }

    @Override
    public long getMonthSalary() {
        return totalSalary;
    }

}

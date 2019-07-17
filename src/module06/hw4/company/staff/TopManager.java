package module06.hw4.company.staff;

public class TopManager implements Employee {
    public static final long SALARY = 50000;
    private final int INTEREST = 100;
    private long salary;
    private String name;
    private long totalSalary;

    public TopManager() {
        this("undefined", SALARY);
    }

    public TopManager(String name, long salary) {
        this.name = name;
        this.salary = salary;
        this.totalSalary = salary;
    }

    public void getBonus() {
        long bonus = (long) Math.round(salary * INTEREST / 100);
        totalSalary = salary + bonus;
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append(name)
                .append(". Топ-менеджер, фиксированный оклад - ").append(salary)
                .append(" и премия, если доход компании будет свыше 10млн руб, составляет ").append(INTEREST)
                .append("% от оклада");

        return info.toString();

//        System.out.printf(
//                "%s является топ-менеджером с окладом %d и премией %d%% от оклада, если доход компании будет свыше 10млн руб\n",
//                name, salary, INTEREST
//        );
    }

    @Override
    public long getMonthSalary() {
        return totalSalary;
    }
}

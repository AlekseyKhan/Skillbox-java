package module06.hw4.company.staff;

public class Operator implements Employee {
    public static final long SALARY = 25000;
    private long salary;
    private String name;

    public Operator(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public Operator() {
        this("undefined", SALARY);
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append(name)
                .append(". Операционист, фиксированный оклад - ").append(salary);

        return info.toString();
//        System.out.printf("%s работает операционистом с фиксированным окладом %d", name, salary);
    }

    @Override
    public long getMonthSalary() {
        return salary;
    }
}

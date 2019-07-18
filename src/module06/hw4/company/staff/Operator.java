package module06.hw4.company.staff;

public class Operator implements Employee {
    public static final long DEFAULT_SALARY = 25000;
    private long salary;
    private String name;

    public Operator(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public Operator() {
        this("undefined", DEFAULT_SALARY);
    }

    @Override
    public long getMonthSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s. Операционист, фиксированный оклад - %d", name, salary);
    }
}

package module06.hw4.company;

import module06.hw4.company.staff.Employee;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    private String sequence;

    SalaryComparator() {
        this("increasing");
    }

    SalaryComparator(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        int sign = sequence.equals("increasing") ? 1 : -1;
        int result = o1.getMonthSalary() > o2.getMonthSalary() ? (-1) * sign : sign;

        return result;
    }
}

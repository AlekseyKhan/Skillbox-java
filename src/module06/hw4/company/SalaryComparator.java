package module06.hw4.company;

import module06.hw4.company.staff.Employee;
import module06.hw4.company.staff.SalaryStaffSequence;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    private SalaryStaffSequence sequence;

    SalaryComparator() {
        this(SalaryStaffSequence.Increasing);
    }

    SalaryComparator(SalaryStaffSequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        int sign = (sequence == SalaryStaffSequence.Increasing) ? 1 : -1;
        return sign * Long.compare(o2.getMonthSalary(), o1.getMonthSalary());
    }
}

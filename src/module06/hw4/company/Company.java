package module06.hw4.company;

import module06.hw4.company.staff.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {
    private List<Employee> staff = new ArrayList<>();
    private static SalaryStaffSequence sortedBy = null;
    private long companyRevenue = 0;

    public boolean hireEmployee(Employee person) {
        if (!staff.contains(person)) {
            staff.add(person);
            return true;
        } else {
            System.out.println("Сотрудник уже существует");
            return false;
        }
    }

    public boolean fireEmployee(Employee person) {
        if (staff.contains(person)) {
            staff.remove(person);
            return true;
        } else {
            System.out.println("Сотрудник не найден");
            return false;
        }
    }


    public void getTopSalaryStaff(int count) {
        if (count > staff.size()) {
            System.out.println("Запрос превышает кол-во сотрудников в штате");
            return;
        }

        sortStaffSalary(SalaryStaffSequence.Increasing);
        showSortedStaffSalary(count, sortedBy);

    }

    public void getLowestSalaryStaff(int count) {
        if (count > staff.size()) {
            System.out.println("Запрос превышает кол-во сотрудников в штате");
            return;
        }

        sortStaffSalary(SalaryStaffSequence.Decreasing);
        showSortedStaffSalary(count, sortedBy);

    }

    public int getCountOfStaff() {
        return staff.size();
    }

    private void sortStaffSalary(SalaryStaffSequence sequence) {
        if (sortedBy == null) {
            Collections.sort(staff, new SalaryComparator(sequence));
            sortedBy = sequence;
        } else if (!sortedBy.equals(sequence)) {
            Collections.reverse(staff);
            sortedBy = sequence;
        }
    }

    private void showSortedStaffSalary(int count, SalaryStaffSequence sequence) {
        String s = sequence.equals(SalaryStaffSequence.Increasing) ?
                String.format("Топ %d самых высокооплачиваемых сотрудников", count) :
                String.format("Топ %d самых низкооплачиваемых сотрудников", count);

        System.out.println(s);
        for (int i = 0; i < count; i++) {
            System.out.printf("%d) Зарплата %d. Кто - %s\n",
                    i + 1,
                    staff.get(i).getMonthSalary(),
                    staff.get(i));
        }
    }

    public long getCompanyRevenue() {
        return companyRevenue;
    }

    public void increaseCompanyRevenue(long income) {
        this.companyRevenue += income;
    }

}

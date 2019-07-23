package module06.hw4.company;

import module06.hw4.company.staff.*;

import java.util.*;

public class Company {
    private List<Employee> staff = new ArrayList<>();
    private long companyRevenue = 0;

    public void hireEmployee(Employee person) {
        if (!staff.contains(person)) {
            staff.add(person);
        } else {
            System.out.println("Сотрудник уже существует");
        }
    }

    public void fireEmployee(Employee person) {
        if (staff.contains(person)) {
            staff.remove(person);
        } else {
            System.out.println("Сотрудник не найден");
        }
    }


    public void getTopSalaryStaff(int count) {
        if (count > staff.size()) {
            System.out.println("Запрос превышает кол-во сотрудников в штате");
            return;
        }
        showSortedStaffSalary(staff, count, SalaryStaffSequence.Increasing);

    }

    public void getLowestSalaryStaff(int count) {
        if (count > staff.size()) {
            System.out.println("Запрос превышает кол-во сотрудников в штате");
            return;
        }
        showSortedStaffSalary(staff, count, SalaryStaffSequence.Decreasing);

    }

    public int getCountOfStaff() {
        return staff.size();
    }

    private void showSortedStaffSalary(List staff, int count, SalaryStaffSequence sequence) {
        List<Employee> sortedStaff = new ArrayList<>(staff);

        System.out.println(sequence.equals(SalaryStaffSequence.Increasing) ?
                String.format("Топ %d самых высокооплачиваемых сотрудников", count) :
                String.format("Топ %d самых низкооплачиваемых сотрудников", count));

        Collections.sort(sortedStaff, new SalaryComparator(sequence));

        for (int i = 0; i < count; i++) {
            System.out.printf("%d) Зарплата %d. Кто - %s\n",
                    i + 1,
                    sortedStaff.get(i).getMonthSalary(),
                    sortedStaff.get(i));
        }

        for (int i = 0; i < count; i++) {
            System.out.printf("%d) Зарплата %d. Кто - %s\n",
                    i + 1,
                    this.staff.get(i).getMonthSalary(),
                    this.staff.get(i));
        }
    }

    public long getCompanyRevenue() {
        return companyRevenue;
    }

    public void increaseCompanyRevenue(long income) {
        this.companyRevenue += income;
    }

}
package module06.hw4.company;

import module06.hw4.company.staff.Employee;
import module06.hw4.company.staff.Operator;
import module06.hw4.company.staff.SalesManager;
import module06.hw4.company.staff.TopManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    private List<Employee> staff = new ArrayList<>();

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


    public long getTopSalaryStaff(int count) {
        if (count > staff.size()) {
            System.out.println("Запрос превышает кол-во сотрудников в штате");
            return 1;
        }

        Collections.sort(staff, new SalaryComparator());
        System.out.printf("Топ %d самых высокооплачиваемых сотрудников\n", count);
        for (int i = 0; i < count; i++) {
            System.out.printf("%d) Зарплата %d. Кто - %s\n",
                    i + 1,
                    staff.get(i).getMonthSalary(),
                    staff.get(i).getInfo());
        }

        return 0;
    }

    public long getLowestSalaryStaff(int count) {
        if (count > staff.size()) {
            System.out.println("Запрос превышает кол-во сотрудников в штате");
            return 1;
        }

        Collections.sort(staff, new SalaryComparator("decreasing"));
        System.out.printf("Топ %d самых низкооплачиваемых сотрудников\n", count);
        for (int i = 0; i < count; i++) {
            System.out.printf("%d) Зарплата %d. Кто - %s\n",
                    i + 1,
                    staff.get(i).getMonthSalary(),
                    staff.get(i).getInfo());
        }
        return 0;
    }

    public int getCountOfStaff() {
        return staff.size();
    }

}

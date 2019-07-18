package module06.hw4.company;

import module06.hw4.company.staff.Operator;
import module06.hw4.company.staff.SalesManager;
import module06.hw4.company.staff.TopManager;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        long companyRevenue = 0;
        long saleIncome = 200000;

        //Создаем обычных продажников
        for (int i = 0; i < 220; i++) {
            long managerSalary = SalesManager.DEFAULT_SALARY;
            String managerName = "Manager " + (i + 1);

            SalesManager manager = new SalesManager(managerName, managerSalary);
            long income = (long) (Math.random() * saleIncome);

            manager.calculateSalary(income);
            company.hireEmployee(manager);
            company.increaseCompanyRevenue(income);
        }

        //Создаем операторов
        for (int i = 0; i < 45; i++) {
            long operatorSalary = Operator.DEFAULT_SALARY;
            String operatorName = "Operator " + (i + 1);

            Operator operator = new Operator(operatorName, operatorSalary);
            company.hireEmployee(operator);
        }

        //Топы
        for (int i = 0; i < 5; i++) {
            long topSalary = TopManager.DEFAULT_SALARY;
            String topName = "Top " + (i + 1);

            TopManager top = new TopManager(topName, topSalary);
            top.calculateBonus(company);
            company.hireEmployee(top);
        }

        System.out.printf("Количество сотрудников: %d. Доход компании за месяц составил - %d\n",
                company.getCountOfStaff(),
                company.getCompanyRevenue());

        company.getTopSalaryStaff(20);
        company.getLowestSalaryStaff(20);

    }
}

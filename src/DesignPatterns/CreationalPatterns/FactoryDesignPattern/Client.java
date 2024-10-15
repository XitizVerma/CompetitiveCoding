package DesignPatterns.CreationalPatterns.FactoryDesignPattern;

public class Client {

    public static void main(String[] args) throws Exception {
        Employee hourlyEmployee = EmployeeFactory.createEmployee(EmployeeType.HOURLY_EMPLOYEE,"Hourly wala",15D,100);
        Employee salariedEmployee = EmployeeFactory.createEmployee(EmployeeType.SALARIED_EMPLOYEE,"Salaried wala", 1000D);

        System.out.println("Hourly Employee name : " + hourlyEmployee.getName() + " and salary : " + hourlyEmployee.getSalary());
        System.out.println("Salaried Employee name : " + salariedEmployee.getName() + " and salary : " + salariedEmployee.getSalary());
    }
}

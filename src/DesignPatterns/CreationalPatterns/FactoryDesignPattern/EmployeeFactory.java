package DesignPatterns.CreationalPatterns.FactoryDesignPattern;

public class EmployeeFactory {

    public static Employee createEmployee(EmployeeType employeeType, String name, Double payrate, Integer ...hours) throws Exception {
        switch (employeeType){
            case HOURLY_EMPLOYEE : return new HourlyEmployee(name,payrate,hours[0]);
            case SALARIED_EMPLOYEE : return new SalariedEmployee(name,payrate);
            default: throw new Exception("No such employee type");
        }
    }
}

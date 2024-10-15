package DesignPatterns.CreationalPatterns.FactoryDesignPattern;

public class SalariedEmployee implements Employee{
    String name;
    Double yearlySalary;

    SalariedEmployee(String name, Double yearlySalary){
        this.name= name;
        this.yearlySalary = yearlySalary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return yearlySalary/12;
    }
}

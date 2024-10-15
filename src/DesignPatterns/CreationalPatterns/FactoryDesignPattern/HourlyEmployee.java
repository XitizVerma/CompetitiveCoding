package DesignPatterns.CreationalPatterns.FactoryDesignPattern;

public class HourlyEmployee implements Employee{

    String name;
    Integer hours;
    Double hourlyRate;

    HourlyEmployee(String name, Double hourlyRate, Integer hours){
        this.name= name;
        this.hours=hours;
        this.hourlyRate=hourlyRate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return hours*hourlyRate;
    }
}

package DesignPatterns.BehavioralPatterns.AdaptorDesignPattern;

public class ChargerXYZ implements AppleCharger{
    @Override
    public void chargeIphone() {
        System.out.println("Your IPhone is charging!");
    }
}

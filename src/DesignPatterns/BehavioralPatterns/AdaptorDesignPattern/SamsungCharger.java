package DesignPatterns.BehavioralPatterns.AdaptorDesignPattern;

public class SamsungCharger implements AndroidCharger{
    @Override
    public void chargeAndroidPhone() {
        System.out.println("Your Samsung Phone is charging!");
    }
}

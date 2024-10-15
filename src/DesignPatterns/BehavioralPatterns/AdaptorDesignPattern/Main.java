package DesignPatterns.BehavioralPatterns.AdaptorDesignPattern;

public class Main {

    public static void main(String[] args) {

        AppleCharger appleCharger = new ChargerXYZ();
        Iphone15 iphone15 = new Iphone15(appleCharger);
        iphone15.chargeIphone();

        AppleCharger charger = new IphoneAdaptorCharger(new SamsungCharger());
        Iphone15 iphone15_2 = new Iphone15(charger);
        iphone15_2.chargeIphone();

    }
}

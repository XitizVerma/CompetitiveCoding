package DesignPatterns.BehavioralPatterns.AdaptorDesignPattern;

public class IphoneAdaptorCharger implements AppleCharger{

    private AndroidCharger androidCharger;

    public IphoneAdaptorCharger(AndroidCharger androidCharger){
        this.androidCharger=androidCharger;
    }

    @Override
    public void chargeIphone() {
        androidCharger.chargeAndroidPhone();

        System.out.println("Your Iphone is being charged with IPhone adaptor of Android Charger");
    }
}

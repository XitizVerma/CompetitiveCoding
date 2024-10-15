package DesignPatterns.BehavioralPatterns.ObserverDesignPattern;

public class Subscriber implements Observer{

    String name;

    Subscriber(String name){
        this.name = name;
    }

    @Override
    public void notified() {
        System.out.println("Hi " + name + " New Video Upload Notification");
    }
}

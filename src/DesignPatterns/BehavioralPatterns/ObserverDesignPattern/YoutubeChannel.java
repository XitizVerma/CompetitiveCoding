package DesignPatterns.BehavioralPatterns.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject{

    private List<Observer> subscriberList = new ArrayList<>();

    @Override
    public void subscribe(Observer ob) {
        this.subscriberList.add(ob);
    }

    @Override
    public void unsubscribe(Observer ob) {
        this.subscriberList.remove(ob);
    }

    @Override
    public void newVideoUpload() {
        for(Observer ob : subscriberList)
            ob.notified();
    }
}

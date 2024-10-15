package DesignPatterns.BehavioralPatterns.ObserverDesignPattern;

public class Main {

    public static void main(String[] args) {
        YoutubeChannel youtubeChannel = new YoutubeChannel();
        Subscriber aman = new Subscriber("Aman");
        youtubeChannel.subscribe(aman);


        youtubeChannel.newVideoUpload();
    }
}

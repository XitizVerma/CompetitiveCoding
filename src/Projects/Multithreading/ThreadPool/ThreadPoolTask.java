package Projects.Multithreading.ThreadPool;

import java.time.ZonedDateTime;

public class ThreadPoolTask implements Runnable {

    private String name;
    ThreadPoolTask(String name){
        this.name=name;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            if(i==0)
                System.out.println(name + " started at " + ZonedDateTime.now());
            else {
                System.out.println(name + " executing at " + ZonedDateTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(name + " complete at " + ZonedDateTime.now());
    }
}

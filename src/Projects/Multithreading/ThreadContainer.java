package Projects.Multithreading;

public class ThreadContainer extends Thread{

    @Override
    public void run(){
        System.out.println("User Thread or Non-Daemon Thread");
    }

}

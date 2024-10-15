package Projects.Multithreading;

public class Main {

    public static void main(String args[]) throws InterruptedException {

        /*
            New Threads in Java can be created either by :
            1. Extending the Thread class, and overriding the run method
            2. Implementing the Runnable interface and overriding the run method
            In both examples invoke thread.start() in order to start the new thread
         */
        ThreadContainer threadContainer = new ThreadContainer();
        threadContainer.start();

        ThreadRunnable threadRunnable = new ThreadRunnable();
        threadRunnable.run();

        System.out.println(threadContainer.getThreadGroup());
        System.out.println(threadContainer.getName());
        System.out.println(threadContainer.isDaemon());
        /*
            A daemon thread is a thread that runs in the background and does not prevent the Java Virtual Machine (JVM)
             from exiting when all non-daemon threads in Java have been completed.
            These threads are typically used to perform background tasks such as garbage collection, monitoring,
             and other system-level operations.
         */
//        threadContainer.setDaemon(true);
        System.out.println(threadContainer.isDaemon());
        System.out.println(threadContainer.getState());

        //---
        System.out.println("------");
        Thread thread = new Thread();
        thread.start();
        System.out.println(thread.isDaemon());
        System.out.println(thread.getName());

        Thread thread2 = new Thread(threadRunnable);
        thread2.start();
        System.out.println(thread2.isDaemon());
        System.out.println(thread2.getName());

        thread.join(); //Prevent Memory and CPU Resource by finishing the thread and so that it could be reclaimed by the JVM
        thread2.join();
    }
}

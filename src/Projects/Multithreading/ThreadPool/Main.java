package Projects.Multithreading.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static final Integer THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {

        ThreadPoolTask task1 = new ThreadPoolTask("Task1");
        ThreadPoolTask task2 = new ThreadPoolTask("Task2");
        ThreadPoolTask task3 = new ThreadPoolTask("Task3");
        ThreadPoolTask task4 = new ThreadPoolTask("Task4");
        ThreadPoolTask task5 = new ThreadPoolTask("Task5");

        ExecutorService pool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        pool.execute(task1);
        pool.execute(task2);
        pool.execute(task3);
        pool.execute(task4);
        pool.execute(task5);

    }
}

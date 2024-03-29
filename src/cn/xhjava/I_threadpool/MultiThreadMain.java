package cn.xhjava.I_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadMain {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 20; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        threadPool.shutdown();


    }

}

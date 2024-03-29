package cn.xhjava.D_jointhread;

/**
 * @author Xiahu
 * @create 2019/10/28
 * @since 1.0.0
 */

/**
 * 线程加塞
 */
public class ThreadJoin {
    public void a(Thread joinThread) {

        System.out.println("方法a执行了...");
        joinThread.start();
        try {
            joinThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a方法执行完毕...");

    }

    public void b() {
        System.out.println("加塞线程开始执行....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("加塞线程执行完毕...");
    }

    public static void main(String[] args) {
        ThreadJoin demo = new ThreadJoin();
        Thread joinThread = new Thread(new Runnable() {

            @Override
            public void run() {
                demo.b();
            }
        });

        new Thread(new Runnable() {

            @Override
            public void run() {
                demo.a(joinThread);
            }
        }).start();
    }
}
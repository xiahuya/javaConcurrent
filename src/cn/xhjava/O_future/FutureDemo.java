package cn.xhjava.O_future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


/**
 * ��ǰ�������
 */
public class FutureDemo {


    /**
     * Callalbe��Runnable������
     * <p>
     * Runnable run�����Ǳ��̵߳��õģ���run�������첽ִ�е�
     * <p>
     * Callable��call�����������첽ִ�еģ�����Future��run�������õ�
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Callable<Integer> call = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("���ڼ�����...");
                Thread.sleep(3000);
                return 1;
            }
        };

        FutureTask<Integer> task = new FutureTask<>(call);

        Thread thread = new Thread(task);
        thread.start();

        // do something
        System.out.println(" �ɵ���...");

        Integer result = task.get();

        System.out.println("�õ��Ľ��Ϊ��" + result);

    }

}
package book.multithreading.ch08.se02;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest3 {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException,
            BrokenBarrierException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                    System.out.println("c await finished");
                } catch (Exception e) {

                }
            }
        });
        thread.start();
        thread.interrupt();

        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(c.isBroken());
        }
        // 打印日志
        System.out.println("main thread is finished");
    }
}

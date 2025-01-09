package book.multithreading.ch08.se03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors
            .newFixedThreadPool(THREAD_COUNT);
    private static CustonSemaphore s = new CustonSemaphore(10);


    public static void main(String[] args) throws InterruptedException {
        s.tryReduce();
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //
                        System.out.println(
                                "vailablePermits: " + s.availablePermits()+"\n"+
                                        "getQueueLength: " + s.getQueueLength()+"\n"+
                                        "hasQueuedThreads: " + s.hasQueuedThreads()+"\n"
                        );
                        s.acquire();
                        System.out.println("save data");
                        Thread.sleep(1000);
                        s.release();
                    } catch (InterruptedException e) {
                    }
                }
            });
        }
        Thread.sleep(2000);
        threadPool.shutdown();
    }
}

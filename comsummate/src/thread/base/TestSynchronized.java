package thread.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSynchronized {
    public synchronized void someMethod() throws InterruptedException {
        // 同步代码块
        System.out.println("同步方法同步代码块");
        Thread.sleep(1000);
    }

    public static synchronized void someStaticMethod() throws InterruptedException {
        // 同步代码块
        // 同步代码块
        System.out.println("静态方法同步代码块");
        Thread.sleep(1000);
    }

    public void someMethod2() throws InterruptedException {
        synchronized(TestSynchronized.class) {
            // 同步代码块
            System.out.println("同步代码块");
            Thread.sleep(10000);
        }
    }

    public static void main(String[] args) {
        final int THREAD_COUNT = 100; // 线程数
        final int NUMBERS_TO_PROCESS = 1000; // 处理的数字范围

        TestSynchronized testSynchronized = new TestSynchronized();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            if (i%3==2){
                executor.submit(()-> {
                    try {
                        testSynchronized.someStaticMethod();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }else if (i%3==1) {
                executor.submit(() -> {
                    try {
                        testSynchronized.someMethod2();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
//            }else{
//                executor.submit(()-> {
//                    try {
//                        testSynchronized.someMethod();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//            }

        }


    }
}

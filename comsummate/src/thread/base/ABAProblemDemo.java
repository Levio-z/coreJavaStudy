package thread.base;

import java.util.concurrent.atomic.AtomicInteger;

public class ABAProblemDemo {

    // 创建一个AtomicInteger，初始值为100
    private static AtomicInteger atomicInt = new AtomicInteger(100);

    public static void main(String[] args) throws InterruptedException {

        // 线程1：尝试在CAS中检测到变化
        Thread t1 = new Thread(() -> {
            int expectedValue = atomicInt.get();
            System.out.println("Thread 1: 初始值: " + expectedValue);

            try {
                // 让线程1稍微等待，以便线程2可以先运行
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // 尝试CAS操作，希望将值从100更新到101
            boolean isCASuccess = atomicInt.compareAndSet(expectedValue, 101);
            System.out.println("Thread 1: CAS 操作 " + (isCASuccess ? "成功" : "失败") + ", 当前值: " + atomicInt.get());
        });

        // 线程2：执行ABA操作
        Thread t2 = new Thread(() -> {
            // 将值从100更新到200
            atomicInt.compareAndSet(100, 200);
            System.out.println("Thread 2: 修改值为 200, 当前值: " + atomicInt.get());

            // 再将值从200改回100
            atomicInt.compareAndSet(200, 100);
            System.out.println("Thread 2: 将值改回 100, 当前值: " + atomicInt.get());
        });

        // 启动线程
        t1.start();
        t2.start();

        // 等待线程完成
        t1.join();
        t2.join();
    }
}

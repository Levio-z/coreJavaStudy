package thread.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComputationExample {
    public static void main(String[] args) {
        final int THREAD_COUNT = 100000000; // 线程数
        final int NUMBERS_TO_PROCESS = 100000000; // 处理的数字范围

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int start = i * NUMBERS_TO_PROCESS / THREAD_COUNT;
            final int end = (i + 1) * NUMBERS_TO_PROCESS / THREAD_COUNT;
            executor.submit(() -> {
                for (int num = start; num < end; num++) {
                    isPrime(num);
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // 等待所有线程完成
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total time: " + (endTime - startTime) + "ms");
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
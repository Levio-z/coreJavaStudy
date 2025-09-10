/**
 * Java False Sharing 演示
 *
 * 测试多线程写入独立计数器时的性能差异
 * 通过填充缓存行可以避免 False Sharing
 * https://mechanical-sympathy.blogspot.com/2011/07/false-sharing.html
 */
public final class FalseSharing implements Runnable {

    // ===============================
    // 配置参数
    // ===============================
    public final static int NUM_THREADS = 4;                       // 线程数
    public final static long ITERATIONS = 500L * 1000L * 1000L;    // 每个线程写入次数

    private final int arrayIndex;   // 当前线程操作的计数器索引

    // ===============================
    // 线程共享数组
    // ===============================
    private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];

    static {
        // 初始化每个计数器对象
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new VolatileLong();
        }
    }

    // ===============================
    // 构造方法
    // ===============================
    public FalseSharing(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    // ===============================
    // 主函数
    // ===============================
    public static void main(final String[] args) throws Exception {
        final long start = System.nanoTime();
        runTest();
        System.out.println("duration = " + ((System.nanoTime() - start) / 1_000_000) + " ms");
    }

    // ===============================
    // 启动线程执行测试
    // ===============================
    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        // 创建线程
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharing(i));
        }

        // 启动线程
        for (Thread t : threads) {
            t.start();
        }

        // 等待所有线程完成
        for (Thread t : threads) {
            t.join();
        }
        // 填充后12s
        // 不填充 32026 ms 
    }

    // ===============================
    // 线程执行逻辑：写入自己的计数器
    // ===============================
    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndex].value = i;  // 写入独立变量
        }
    }

    // ===============================
    // 计数器类
    // ===============================
    public final static class VolatileLong {
        public volatile long value = 0L;  // 线程操作的核心变量

        // 填充字段（避免 False Sharing）
        // 每个 long 8 字节，7 个 long ≈ 56 字节，加上对象头 8 字节 ≈ 64 字节缓存行
        public long p1, p2, p3, p4, p5, p6; 
    }
}

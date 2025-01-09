package book.multithreading.ch10.se04;

import java.util.concurrent.*;

public class TestFutureTask {
    private final ConcurrentMap<Object, Future<String>> taskCache =
            new ConcurrentHashMap<Object, Future<String>>();
    public String executionTask(final String taskName)throws ExecutionException, InterruptedException {
        while (true) {
            Future<String> future = taskCache.get(taskName); // 1.1,2.1
            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    public String call() throws InterruptedException {
                        System.out.println("任务"+taskName);
                        return taskName;
                    }
                };                                                                                                // 1.2创建任务
                FutureTask<String> futureTask = new FutureTask<String>(task);
                future = taskCache.putIfAbsent(taskName, futureTask); // 1.3
                if (future == null) {
                    future = futureTask;
                    futureTask.run();                               // 1.4执行任务
                }
            }
            try {
                return future.get();                                      // 1.5,2.2线程在此等待任务执行完成
            } catch (CancellationException e) {
                taskCache.remove(taskName, future);
            }
        }
    }
    public static void main(String[] args) {
        TestFutureTask task = new TestFutureTask();
        String name ="123";
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        // 打印当前线程名称
                        System.out.println("线程"+Thread.currentThread().getName()+"正在执行"+"任务"+task.executionTask("任务"+i));
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        };
        executorService.execute(runnable);
        executorService.execute(runnable);

    }
}

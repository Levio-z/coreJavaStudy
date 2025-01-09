package book.multithreading.ch08.se03;

import java.util.concurrent.Semaphore;

public class CustonSemaphore extends Semaphore {
    public CustonSemaphore(int permits) {
        super(permits);
    }

    public CustonSemaphore(int permits, boolean fair) {
        super(permits, fair);
    }

    @Override
    public void reducePermits(int reduction) {
        if (reduction > 0) {
            super.reducePermits(reduction);
        }
    }
    public void tryReduce(){
        reducePermits(1);
    }
}

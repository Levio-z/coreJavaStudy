package book.multithreading.ch07.se03;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableReferenceExample {
    public static void main(String[] args) {
        // 初始引用和标记
        String initialRef = "Initial Value";
        boolean initialMark = false;
        AtomicMarkableReference<String> atomicMarkableReference = new AtomicMarkableReference<>(initialRef, initialMark);

        // 获取当前引用和标记
        String currentRef = atomicMarkableReference.getReference();
        boolean currentMark = atomicMarkableReference.isMarked();

        // 设置新的引用和标记
        atomicMarkableReference.set(initialRef, true);

        // 比较引用并设置新的引用和标记
        boolean casSuccess = atomicMarkableReference.compareAndSet(initialRef, "Updated Value", currentMark, !currentMark);
        System.out.println("CAS operation success: " + casSuccess);
    }
}
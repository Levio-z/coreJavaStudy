    package book.multithreading.ch07.se03;

import java.util.concurrent.atomic.AtomicReference;

class AtomicReferenceExample {
    public static void main(String[] args) {
        AtomicReference<String> atomicReference = new AtomicReference<>("Initial Value");

        // 获取当前引用
        String current = atomicReference.get();

        // 设置新的引用
        atomicReference.set("New Value");

        // 比较并设置
        boolean casSuccess = atomicReference.compareAndSet(current, "Updated Value");
        System.out.println("CAS operation success: " + casSuccess);
    }
}
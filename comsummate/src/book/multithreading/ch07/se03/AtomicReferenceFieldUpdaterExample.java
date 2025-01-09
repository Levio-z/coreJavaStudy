package book.multithreading.ch07.se03;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

class User {
    volatile String name;
}

public class AtomicReferenceFieldUpdaterExample {
    private static final AtomicReferenceFieldUpdater<User, String> updater =
            AtomicReferenceFieldUpdater.newUpdater(User.class, String.class, "name");

    public static void main(String[] args) {
        User user = new User();
        user.name = "Initial Name";

        // 获取当前字段值
        String currentName = updater.get(user);
        System.out.println(currentName);

        // 设置新的字段值
        updater.set(user, "New Name");

        // 比较并设置
        boolean casSuccess = updater.compareAndSet(user, currentName, "Updated Name");
        System.out.println("CAS operation success: " + casSuccess);
    }
}
package collection.priorityQueue;

import java.util.PriorityQueue;

public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add("1");
        priorityQueue.add("2");
        priorityQueue.add("3");
        priorityQueue.add("4");
        priorityQueue.add("5");
        boolean remove = priorityQueue.remove("4");
        priorityQueue.stream().forEach(System.out::println);
    }
}

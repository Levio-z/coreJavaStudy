package leetcode.back;

import java.util.ArrayList;
import java.util.List;


public class KnapsackOptimizer {

    public static List<Item> optimizeItems(List<Item> items, int V) {
        // 去除费用大于背包容量的物品
        items.removeIf(item -> item.weight > V);

        // 计数排序的准备：找出最大费用
        int maxWeight = items.stream().mapToInt(Item::getWeight).max().orElse(0);

        // 计数数组，用于统计每个费用值有多少种物品
        int[] count = new int[maxWeight + 1];

        // 物品价值数组，用于存储每个费用下的最大价值
        int[] maxValue = new int[maxWeight + 1];

        // 遍历物品，填充计数和价值数组
        for (Item item : items) {
            count[item.weight]++;
            if (maxValue[item.weight] < item.value) {
                maxValue[item.weight] = item.value;
            }
        }

        // 使用计数数组和价值数组重建优化后的物品列表
        List<Item> optimizedItems = new ArrayList<>();
        for (int weight = 1; weight <= maxWeight; weight++) {
            if ( count[weight]>0) {
                optimizedItems.add(new Item(weight, maxValue[weight]));
            }
        }

        return optimizedItems;
    }

    // 测试优化方法
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        // 假设添加了一些物品
        items.add(new Item(10, 60));
        items.add(new Item(20, 100));
        items.add(new Item(30, 120));
        items.add(new Item(21, 100));

        int V = 50; // 背包容量

        List<Item> optimizedItems = optimizeItems(items, V);
        for (Item item : optimizedItems) {
            System.out.println("Weight: " + item.weight + ", Value: " + item.value);
        }
        String str = "hello world";
        String substring = str.substring(0, 100);
    }
}
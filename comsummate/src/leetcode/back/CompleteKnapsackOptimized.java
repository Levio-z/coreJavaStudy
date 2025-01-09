package leetcode.back;

import java.util.Arrays;
import java.util.Comparator;

// 定义物品的类
class Item {
    int weight;
    int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class CompleteKnapsackOptimized {

    // 预处理和优化物品列表
    public static Item[] preprocessAndOptimize(Item[] items, int N) {
        // 按费用对物品进行排序
        Arrays.sort(items, Comparator.comparingInt(i -> i.getWeight()));

        // 使用数组来存储优化后的物品
        Item[] optimizedItems = new Item[N];
        // 数组大小
        int optimizedCount = 0;

        for (int i = 0; i < N; i++) {
            boolean shouldKeep = true;
            // 遍历优化后数组大小
            for (int j = 0; j < optimizedCount; j++) {
                // 如果当前物品的重量大于优化后物品，但是价值小于优化后物品，则替换
                if (items[i].weight >= optimizedItems[j].weight && items[i].value < optimizedItems[j].value) {
                    shouldKeep = false;
                    break;
                }
            }
            if (shouldKeep) {
                optimizedItems[optimizedCount++] = items[i];
            }
        }

        // 调整优化后物品数组的大小
        Item[] finalOptimizedItems = Arrays.copyOf(optimizedItems, optimizedCount);
        return finalOptimizedItems;
    }

    // 执行完全背包问题的动态规划算法
    public static int knapsack(Item[] items, int V) {
        int N = items.length;
        int[] dp = new int[V + 1];
        Arrays.fill(dp, 0);

        for (int i = 0; i < N; i++) {
            for (int v = items[i].weight; v <= V; v++) {
                dp[v] = Math.max(dp[v], dp[v - items[i].weight] + items[i].value);
            }
        }

        return dp[V];
    }

    // 主函数，用于测试
    public static void main(String[] args) {
        // 创建物品列表
        Item[] items = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120),
            new Item(21, 90) // 这个物品将被优化掉
        };
        int N = items.length;
        int V = 50; // 背包容量

        // 预处理和优化物品
        Item[] optimizedItems = preprocessAndOptimize(items, N);

        // 执行背包问题
        int maxProfit = knapsack(optimizedItems, V);
        System.out.println("The maximum profit is: " + maxProfit);
    }


}

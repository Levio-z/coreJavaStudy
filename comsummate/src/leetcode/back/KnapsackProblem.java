package leetcode.back;

public class KnapsackProblem {

    static int knapsack(int W, int[] weights, int[] values, int N) {
        // dp数组，dp[i]表示容量为i的背包能得到的最大价值
        int[] dp = new int[W + 1];

        // 不要求必须把背包装满的情况
        for (int i = 0; i <= W; i++) {
            dp[i] = i >= weights[0] ? values[0] : 0;
        }

        // 动态规划填表
        for (int i = 1; i < N; i++) {
            for (int j = W; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        // 返回最大价值
        return dp[W];
    }

    static int knapsackExactFit(int W, int[] weights, int[] values, int N) {
        // dp数组，dp[i]表示容量为i的背包能得到的最大价值
        int[] dp = new int[W + 1];
        // 初始化除了容量为0的背包，其余容量的背包价值为-∞
        for (int i = 1; i <= W; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        // 容量为0的背包什么也不装，价值为0
        dp[0] = 0;

        // 动态规划填表
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (j >= weights[i - 1] && dp[j - weights[i - 1]] != Integer.MIN_VALUE ) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
                }
            }
        }

        return dp[W]==Integer.MIN_VALUE?-1:dp[W];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120}; // 物品价值
        int[] weights = {10, 20, 30};   // 物品重量
        int W = 51;                     // 背包容量
        int N = values.length;          // 物品数量

        // 不要求必须把背包装满
        System.out.println("Maximum value without exact fit: " + knapsack(W, weights, values, N));

        // 要求恰好装满背包
        System.out.println("Maximum value with exact fit: " + knapsackExactFit(W, weights, values, N));
    }
}
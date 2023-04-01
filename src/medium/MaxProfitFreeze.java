package medium;

public class MaxProfitFreeze {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 不持有
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            if (i < 2) {
                // 前一天持有 或者直接买入
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }

        }

        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {2, 1, 4};

        System.out.println(maxProfit(prices));
    }
}

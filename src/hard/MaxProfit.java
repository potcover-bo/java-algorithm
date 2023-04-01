package hard;

/**
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][3][2];

        for (int i = 0; i < n; i++) {
            for (int k = 2; k > 0; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                }else {
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i-1][k-1][0] - prices[i]);
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                }
            }
        }

        return dp[n - 1][2][0];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        System.out.println(maxProfit(prices));
    }
}

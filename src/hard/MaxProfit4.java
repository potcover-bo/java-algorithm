package hard;

public class MaxProfit4 {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2) {
            k = n / 2;
        }
        int[][][] dp = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int max_k = k; max_k > 0; max_k--) {
                if (i == 0) {
                    dp[i][max_k][0] = 0;
                    dp[i][max_k][1] = -prices[i];
                }else {
                    dp[i][max_k][1] = Math.max(dp[i - 1][max_k][1], dp[i-1][max_k-1][0] - prices[i]);
                    dp[i][max_k][0] = Math.max(dp[i - 1][max_k][0], dp[i - 1][max_k][1] + prices[i]);
                }
            }
        }

        return dp[n - 1][k][0];
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(2, prices));
    }
}

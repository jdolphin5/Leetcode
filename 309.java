class Solution {

    private int helper(int[][] dp, int[] prices, int i, int buyPrice) {
        if (i >= prices.length) {
            return 0;
        }
        if (dp[i][buyPrice+1] != -1) {
            return dp[i][buyPrice+1];
        }
        if (buyPrice == -1) {
            int a = helper(dp, prices, i+1, prices[i]);
            int b = helper(dp, prices, i+1, -1);
            return dp[i][buyPrice+1] = Math.max(a, b);
        }
        //else
        int a = 0;
        if (prices[i] > buyPrice)
            a = prices[i] - buyPrice + helper(dp, prices, i+2, -1);
        int b = helper(dp, prices, i+1, buyPrice);
        return dp[i][buyPrice+1] = Math.max(a, b);
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][1002];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(dp, prices, 0, -1);
    }
}
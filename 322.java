class Solution {

    private int helper(int[] coins, int[][] dp, int cur, int i) {
        //System.out.println(" cur: " + cur + " i: " + i);
        if (i == coins.length-1) {
            if (cur % coins[i] == 0) return cur / coins[i];
            else return 50000;
        }
        if (dp[i][cur] != -1) {
            return dp[i][cur];
        }
        int a = 50000;
        if (coins[i] <= cur) {
            a = 1 + helper(coins, dp, cur-coins[i], i);
        }
        int b = helper(coins, dp, cur, i+1);
        return dp[i][cur] = Math.min(a, b);
        
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        int ret = helper(coins, dp, amount, 0);
        return ret != 50000 ? ret : -1;
    }
}
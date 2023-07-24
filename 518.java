class Solution {
    private int helper(int[][] dp, int amount, int[] coins, int i, int curSum) {
        if (curSum == amount) {
            return 1;
        }
        if (i >= coins.length || curSum > amount) {
            return 0;
        }
        if (dp[i][curSum] != -1) {
            return dp[i][curSum];
        }
        int take = helper(dp, amount, coins, i, curSum+coins[i]);
        int leave = helper(dp, amount, coins, i+1, curSum);
        return dp[i][curSum] = take + leave;
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][5001];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(dp, amount, coins, 0, 0);
    }
}
class Solution {

    private int helper(int[][] dp, int[] coins, int remaining, int index) {
        if (index >= coins.length) {
            if (remaining == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
        
        if (dp[index][remaining] != -1) {
            return dp[index][remaining];
        }

        int take = 0;
        if (coins[index] <= remaining)
            take = helper(dp, coins, remaining-coins[index], index);
        int leave = helper(dp, coins, remaining, index+1);
        return dp[index][remaining] = take + leave;

    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[301][5001]; //index, amount
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(dp, coins, amount, 0);
    }
}
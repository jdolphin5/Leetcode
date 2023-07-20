class Solution {
    private int helper(int[] dp, int i, int cur, int[] cost) {
        if (i < 0) {
            return 0;
        }
        if (i == 0 || i == 1) return cost[i];
        if (dp[i] != 0) {
            return dp[i];
        }
        return dp[i] = cost[i] + Math.min(helper(dp, i-1, cur, cost), helper(dp, i-2, cur, cost)); 

    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        return Math.min(helper(dp, cost.length-1, 0, cost), helper(dp, cost.length-2, 1, cost));
    }
}
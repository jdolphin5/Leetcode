class Solution {
    //dp arr, cost arr, time arr, index, sum of time, target time
    private long recur(Long[][] dp, int[] cost, int[] time, int i, int sum, int target) {
        if (i == cost.length) {
            return sum >= target ? 0 : Integer.MAX_VALUE;
        }
        if (sum >= target) {
            return 0;
        }

        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        long take = Integer.MAX_VALUE;
        long leave = Integer.MAX_VALUE;
        take = cost[i] + recur(dp, cost, time, i+1, sum + time[i] + 1, target);
        leave = recur(dp, cost, time, i+1, sum, target);

        return dp[i][sum] = Math.min(take, leave);
    }

    public int paintWalls(int[] cost, int[] time) {
        Long[][] dp = new Long[cost.length][501]; //index, sum of time

        return (int)recur(dp, cost, time, 0, 0, time.length);
    }
}
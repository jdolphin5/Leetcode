class Solution {
    private int recur(Integer[][] dp, int k, int n, int i, int sum, int target) {
        if (sum > target) {
            return 0;
        }
        if (i == n) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        int ans = 0;

        final int MOD = 1000000007;

        for (int x = 1; x <= k; x++) {
            ans += recur(dp, k, n, i+1, sum+x, target);
            ans %= MOD;
        }

        return dp[i][sum] = ans;
    }

    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n][target+1];
        return recur(dp, k, n, 0, 0, target);
    }
}
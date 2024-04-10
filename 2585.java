class Solution {
    private int recur(int target, int[][] types, Integer[][] dp, int i) {
        final int MOD = 1000000007;
        
        if (target == 0) {
            return 1;
        }
        if (i == types.length) {
            return 0;
        }
        if (dp[i][target] != null) {
            return dp[i][target];
        }

        int ct = types[i][0];
        int val = 0;
        int ans = 0;

        for (int j = 0; j <= ct; j++) {
            if (val <= target) {
                ans = ans + (recur(target - val, types, dp, i+1)) % MOD;
                ans %= MOD;
            }
            
            val += types[i][1];
        }

        return dp[i][target] = ans % MOD;
    }

    public int waysToReachTarget(int target, int[][] types) {
        Integer[][] dp = new Integer[types.length][target+1];

        return recur(target, types, dp, 0);
    }
}
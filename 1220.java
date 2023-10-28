class Solution {
    private long recur(Long[][] dp, int rem, int cur) {
        if (rem == 0) {
            return 1;
        }

        if (dp[rem][cur] != null) {
            return dp[rem][cur];
        }

        final int MOD = 1000000007;

        switch(cur) {
            case 0:
                dp[rem][cur] = recur(dp, rem-1, 1) % MOD;
                break;
            case 1:
                dp[rem][cur] = (recur(dp, rem-1, 0) + recur(dp, rem-1, 2)) % MOD;
                break;
            case 2:
                dp[rem][cur] = (recur(dp, rem-1, 0) + recur(dp, rem-1, 1) + recur(dp, rem-1, 3) + recur(dp, rem-1, 4)) % MOD;
                break;
            case 3:
                dp[rem][cur] = (recur(dp, rem-1, 2) + recur(dp, rem-1, 4)) % MOD;
                break;
            case 4:
                dp[rem][cur] = recur(dp, rem-1, 0) % MOD;
                break;
        }

        return dp[rem][cur];
    }

    public int countVowelPermutation(int n) {
        final int MOD = 1000000007;
        long ret = 0;
        Long[][] dp = new Long[n+1][5];

        ret = recur(dp, n-1, 0) + recur(dp, n-1, 1) + recur(dp, n-1, 2) + recur(dp, n-1, 3) + recur(dp, n-1, 4);

        return (int)(ret % MOD);
    }
}
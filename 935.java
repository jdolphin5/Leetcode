class Solution {
    private long recur(Long[][] dp, int i, int cur, int n) {
        if (i == n) {
            return 1;
        }

        if (dp[i][cur] != null) {
            return dp[i][cur];
        }

        final int MOD = 1000000007;

        long ret = 0;

        switch (cur) {
            case 0:
                ret += recur(dp, i+1, 4, n) + recur(dp, i+1, 6, n);
                break;
            case 1:
                ret += recur(dp, i+1, 6, n) + recur(dp, i+1, 8, n);
                break;
            case 2:
                ret += recur(dp, i+1, 9, n) + recur(dp, i+1, 7, n);
                break;
            case 3:
                ret += recur(dp, i+1, 4, n) + recur(dp, i+1, 8, n);
                break;
            case 4:
                ret += recur(dp, i+1, 3, n) + recur(dp, i+1, 9, n) + recur(dp, i+1, 0, n);
                break;
            case 5:
                break;
            case 6:
                ret += recur(dp, i+1, 1, n) + recur(dp, i+1, 0, n) + recur(dp, i+1, 7, n);
                break;
            case 7:
                ret += recur(dp, i+1, 2, n) + recur(dp, i+1, 6, n);
                break;
            case 8:
                ret += recur(dp, i+1, 1, n) + recur(dp, i+1, 3, n);
                break;
            case 9:
                ret += recur(dp, i+1, 2, n) + recur(dp, i+1, 4, n);
                break;
        }

        ret %= MOD;

        return dp[i][cur] = ret;
    }

    public int knightDialer(int n) {
        final int MOD = 1000000007;

        if (n == 1) return 10;

        long ret = 0;

        for (int i = 0; i <= 9; i++) {
            if (i == 5) continue;
            ret += recur(new Long[n][10], 1, i, n);
            ret %= MOD;
        }
        
        return (int)ret;
    }
}
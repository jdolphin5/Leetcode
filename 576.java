class Solution {
    private int recur(Integer[][][] dp, int m, int n, int moves, int i, int j) {
        int ret = 0;
        final int MOD = 1000000007;
        
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }

        if (dp[i][j][moves] != null) {
            return dp[i][j][moves];
        }

        if (moves == 0) {
            return 0;
        }

        ret += recur(dp, m, n, moves - 1, i - 1, j);
        ret %= MOD;
        ret += recur(dp, m, n, moves - 1, i + 1, j);
        ret %= MOD;
        ret += recur(dp, m, n, moves - 1, i, j - 1);
        ret %= MOD;
        ret += recur(dp, m, n, moves - 1, i, j + 1);
        ret %= MOD;

        return dp[i][j][moves] = ret;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[m][n][maxMove+1];
        
        final int MOD = 1000000007;

        return recur(dp, m, n, maxMove, startRow, startColumn) % MOD;
    }
}
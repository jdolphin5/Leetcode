class Solution {

    private int helper(int[][][] dp, int m, int n, int remainingMoves, int row, int col, final int MOD) {
        if (row >= m || row < 0 || col >= n || col < 0) {
            return 1;
        }
        if (remainingMoves == 0) {
            return 0;
        }
        if (dp[row][col][remainingMoves] != -1) {
            return dp[row][col][remainingMoves];
        }

        int left = helper(dp, m, n, remainingMoves-1, row, col-1, MOD);
        int right = helper(dp, m, n, remainingMoves-1, row, col+1, MOD);
        int up = helper(dp, m, n, remainingMoves-1, row-1, col, MOD);
        int down = helper(dp, m, n, remainingMoves-1, row+1, col, MOD);

        return dp[row][col][remainingMoves] = (int)(((long)left + right + down + up + MOD) % MOD);
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1000000007;
        int[][][] dp = new int[m][n][51];
        for (int[][] arr1 : dp) {
            for (int[] arr2 : arr1) {
                Arrays.fill(arr2, -1);
            }
        }

        return helper(dp, m, n, maxMove, startRow, startColumn, MOD);

    }
}
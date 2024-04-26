class Solution {
    private int recur(Integer[][] dp, int[][] grid, int i, int j) {
        if (i == grid.length) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int x = 0; x < grid[0].length; x++) {
            if (x == j) continue;
            ans = Math.min(ans, grid[i][j] + recur(dp, grid, i+1, x));
        }

        return dp[i][j] = ans;
    }

    public int minFallingPathSum(int[][] grid) {
        if (grid.length == 1) return grid[0][0];

        Integer[][] dp = new Integer[grid.length][grid[0].length];
        int ret = Integer.MAX_VALUE;

        for (int j = 0; j < grid[0].length; j++)
            ret = Math.min(ret, recur(dp, grid, 0, j));

        return ret;
    }
}
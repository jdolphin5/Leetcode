class Solution {
    private int helper(int[][] grid, Integer[][] dp, int i, int j) {
        if (i > grid.length-1 || j > grid[0].length-1) {
            return 100000;
        }
        if (i == grid.length-1 && j == grid[0].length-1) {
            return grid[i][j];
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        return dp[i][j] = grid[i][j] + Math.min(
            helper(grid, dp, i+1, j),
            helper(grid, dp, i, j+1)
        );
    }

    public int minPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];

        return helper(grid, dp, 0, 0);
    }
}
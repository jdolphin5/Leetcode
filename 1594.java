class Solution {
    long ret = -1;

    private void recur(int[][] grid, int i, int j, int m, int n, long prod) {
        if (i >= m || j >= n) {
            return;
        }

        prod = prod * grid[i][j];

        if (i == m-1 && j == n-1) {
            ret = Math.max(ret, prod);
            return;
        }

        if (grid[i][j] == 0) {
            ret = Math.max(ret, 0);
            return;
        }

        recur(grid, i+1, j, m, n, prod);
        recur(grid, i, j+1, m, n, prod); 
    }

    public int maxProductPath(int[][] grid) {
        recur(grid, 0, 0, grid.length, grid[0].length, 1);

        return ret < 0 ? -1 : (int)(ret % 1000000007);
    }
}
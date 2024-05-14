class Solution {
    private int recur(int[][] grid, int i, int j, boolean[][] visited) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int left = recur(grid, i, j-1, visited);
        int right = recur(grid, i, j+1, visited);
        int top = recur(grid, i-1, j, visited);
        int bot = recur(grid, i+1, j, visited);

        visited[i][j] = false;

        return grid[i][j] + Math.max(left, Math.max(right, Math.max(top, bot)));
    }

    public int getMaximumGold(int[][] grid) {
        int ret = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ret = Math.max(ret, recur(grid, i, j, new boolean[grid.length][grid[0].length]));
            }
        }

        return ret;
    }
}
class Solution {

    private int BFS(int[][] grid, int i, int j, int area) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) return area;
        grid[i][j] = 0;
        area++;
        area = BFS(grid, i-1, j, area);
        area = BFS(grid, i+1, j, area);
        area = BFS(grid, i, j-1, area);
        area = BFS(grid, i, j+1, area);
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, BFS(grid, i, j, 0));
                }
            }
        }
        return max;
    }
}
class Solution {
    public int islandPerimeter(int[][] grid) {
        int landCount = 0;
        int connectedCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    landCount++;

                    if (i - 1 >= 0 && grid[i-1][j] == 1)
                        connectedCount++;
                    if (i + 1 < grid.length && grid[i+1][j] == 1)
                        connectedCount++;
                    if (j - 1 >= 0 && grid[i][j-1] == 1)
                        connectedCount++;
                    if (j + 1 < grid[0].length && grid[i][j+1] == 1)
                        connectedCount++;
                }
            }
        }

        return (landCount * 4) - connectedCount;
    }
}
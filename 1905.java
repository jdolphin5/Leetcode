public class Solution {
    private int checkIsland(int i, int j, int[][] grid1, int[][] grid2, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] == 0) {
            return 0;
        }

        if (grid1[i][j] == 0)
            return -250000;

        grid1[i][j] = 0;
        grid2[i][j] = 0;

        int left = checkIsland(i, j-1, grid1, grid2, m, n);
        int right = checkIsland(i, j+1, grid1, grid2, m, n);
        int up = checkIsland(i-1, j, grid1, grid2, m, n);
        int down = checkIsland(i+1, j, grid1, grid2, m, n);

        return 1 + left + right + up + down;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;

        int ret = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 1) {
                    int check = checkIsland(i, j, grid1, grid2, m, n);
                    if (check > 0)
                        ret++;
                    //System.out.println("i: " + i + " j: " + j);
                }

            }
        }

        return ret;
    }
} 1905 {
    
}

class Solution {
    public int findChampion(int[][] grid) {
        
        for (int i = 0; i < grid.length; i++) {
            int ct = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ct++;
                }
            }
            if (ct == grid.length-1) {
                return i;
            }
        }
        
        return 0;
    }
}
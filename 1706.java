class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];

        if (n == 1) {
            result[0] = -1;
            return result;
        }
        
        int curCol = 0;
        outerloop:
        for (int j = 0; j < n; j++) {
            curCol = j;
            result[j] += curCol;
            for (int i = 0; i < m; i++) {
                    if (curCol < n && curCol >= 0) {
                        result[j] = result[j] + grid[i][curCol];
                        if (result[j] >= n) result[j] = -1;
                        if (grid[i][curCol] == 1) {
                            curCol++;
                            if (curCol < n) {
                                if (grid[i][curCol] == -1) {
                                    result[j] = -1;
                                    continue outerloop;
                                }
                            }
                        }
                        else {
                            curCol--;
                            if (curCol >= 0) {
                                if (grid[i][curCol] == 1) {
                                    result[j] = -1;
                                    continue outerloop;
                                }
                            }
                        }
                    }
                    else {
                        result[j] = -1;
                    }
            }
        }

        //if its going to right and right+1 is -1 continue (hit V)
        //if its going to left and left+1 is 1 continue
        return result;
    }
}
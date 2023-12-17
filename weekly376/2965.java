class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ret = new int[2];
        
        int n = grid.length;
        
        int[] bucket = new int[(n*n)+1];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                bucket[grid[i][j]]++;
            }
        }
        
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 2) {
                ret[0] = i;
            }
            else if (bucket[i] == 0) {
                ret[1] = i;
            }
        }
        
        return ret;
    }
}
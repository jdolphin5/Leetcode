class Solution {
    private int recur(Integer[][] dp, int[][] numCounts, int leftVal, int j, int x) {
        if (j == numCounts.length) {
            return 0;
        }
        
        if (dp[j][leftVal] != null) {
            return dp[j][leftVal];
        }
        
        
        int ans = Integer.MAX_VALUE;
        int n = x;
        
        for (int i = 0; i < numCounts[0].length; i++) {
           
            int amt = numCounts[j][i];
            
            if (i == leftVal) {
                amt = 0;
            }
            
            ans = Math.min(ans, n - amt + recur(dp, numCounts, i, j+1, x));
        }
        
        
        return dp[j][leftVal] = ans;
        
    }
    
    public int minimumOperations(int[][] grid) {
        int[][] numCounts = new int[grid[0].length][11];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                numCounts[j][grid[i][j]]++;
            }
        }
        
        Integer[][] dp = new Integer[grid[0].length][11];
        
        int ret = recur(dp, numCounts, 10, 0, grid.length);
        
        //System.out.println(Arrays.deepToString(numCounts));
        
        return ret;
    }
}
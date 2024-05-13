class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int[][] gridArr = new int[grid.size()][grid.get(0).size()];
        
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                gridArr[i][j] = grid.get(i).get(j);
            }
        }
        
        int[][] dp = new int[gridArr.length][gridArr[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -100001);
        }
        
        int ret = -100001;
        
        for (int i = 0; i < gridArr.length; i++) {
            for (int j = 0; j < gridArr[0].length; j++) {
                for (int x = i+1; x < gridArr.length; x++) {
                    dp[x][j] = Math.max(dp[x][j], Math.max(dp[i][j] + gridArr[x][j] - gridArr[i][j], gridArr[x][j] - gridArr[i][j]));
                }
                for (int y = j+1; y < gridArr[0].length; y++) {
                    dp[i][y] = Math.max(dp[i][y], Math.max(dp[i][j] + gridArr[i][y] - gridArr[i][j], gridArr[i][y] - gridArr[i][j]));
                }

                ret = Math.max(ret, dp[i][j]);
            }
        }

        //System.out.println(Arrays.deepToString(dp));
        
        return ret;
    }
}
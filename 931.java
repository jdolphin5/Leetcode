class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[m-1][j] = matrix[m-1][j];
        }

        for (int i = m-2; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                int c = Integer.MAX_VALUE;

                if (j >= 1) {
                    a = dp[i+1][j-1];
                }

                b = dp[i+1][j];

                if (j < n-1) {
                    c = dp[i+1][j+1];
                }

                int min = Math.min(a, Math.min(b, c));

                dp[i][j] = min + matrix[i][j];
            }
        }

        //System.out.println(Arrays.deepToString(dp));

        int ret = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ret = Math.min(ret, dp[0][j]);
        }

        return ret;
    }
}
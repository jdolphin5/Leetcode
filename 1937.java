class Solution {
    public long maxPoints(int[][] points) {
        long[] dp = new long[points[0].length];

        for (int i = 0; i < points[0].length; i++) {
            dp[i] = points[0][i];
        }

        for (int i = 1; i < points.length; i++) {
            long[] left = new long[points[0].length];
            long[] right = new long[points[0].length];

            left[0] = dp[0];
            for (int j = 1; j < points[0].length; j++) {
                left[j] = Math.max(dp[j], left[j-1] - 1);
            }

            int lastCell = points[0].length-1;

            right[lastCell] = dp[lastCell];
            for (int j = lastCell-1; j >= 0; j--) {
                right[j] = Math.max(dp[j], right[j+1] - 1);
            }

            for (int j = 0; j < points[0].length; j++)
                dp[j] = points[i][j] + Math.max(left[j], right[j]);
        }

        //System.out.println(Arrays.deepToString(dp));

        long ret = 0;

        for (long x : dp) {
            ret = Math.max(ret, x);
        }

        return ret;
    }
}
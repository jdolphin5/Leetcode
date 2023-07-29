class Solution {
    private double helper(double[][] dp, int leftRem, int rightRem) {
        if (leftRem <= 0 && rightRem <= 0) {
            return 0.5;
        }
        else if (leftRem <= 0) {
            return 1.0;
        }
        else if (rightRem <= 0) {
            return 0.0;
        }

        if (dp[leftRem][rightRem] != 0) {
            return dp[leftRem][rightRem];
        }

        dp[leftRem][rightRem] = 0.25 * (helper(dp, leftRem-100, rightRem) + helper(dp, leftRem-75, rightRem-25) + helper(dp, leftRem-50, rightRem-50) + helper(dp, leftRem-25, rightRem-75));
        return dp[leftRem][rightRem];
        
    }

    public double soupServings(int n) {
        if (n > 4800) return 1.0;
        double[][] dp = new double[5000][5000];

        return helper(dp, n, n);

    }
}
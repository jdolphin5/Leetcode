class Solution {

    private boolean helper(Boolean[][] dp, String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length()) return true;

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean ret = false;

        if (i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
            ret = ret || helper(dp, s1, s2, s3, i+1, j, k+1);
        }

        if (j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
            ret = ret || helper(dp, s1, s2, s3, i, j+1, k+1);
        }
        return dp[i][j] = ret;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];

        return helper(dp, s1, s2, s3, 0, 0, 0);
    }
}
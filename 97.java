class Solution {
    
    private boolean helper(Boolean[][] dp, String s1, String s2, String s3, int i, int j, int k) {
        if (s3.length() == k)
            return true;

        if (dp[i][j] != null)
            return dp[i][j];

        boolean left = false;
        boolean right = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
            left = helper(dp, s1, s2, s3, i+1, j, k+1);
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
            right = helper(dp, s1, s2, s3, i, j+1, k+1);
        
        return dp[i][j] = left || right;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;

        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];

        return helper(dp, s1, s2, s3, 0, 0, 0);
    }
}
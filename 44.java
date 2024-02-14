class Solution {
    private boolean recur(Boolean[][] dp, String s, String p, int i, int pIndex) {
        if (i == s.length() && pIndex == p.length()) {
            return true;
        }
        else if (i == s.length()) {
            if (p.charAt(pIndex) == '*')
                return recur(dp, s, p, i, pIndex+1);
            return false;
        }
        if (pIndex == p.length()) {
            return false;
        }

        if (dp[i][pIndex] != null) {
            return dp[i][pIndex];
        }

        if (p.charAt(pIndex) == '*') {
            //move forward until next char
            return dp[i][pIndex] = recur(dp, s, p, i+1, pIndex) || recur(dp, s, p, i, pIndex+1) || recur(dp, s, p, i+1, pIndex+1);
        }
        else if (p.charAt(pIndex) == '?') {
            //move forward once
            return dp[i][pIndex] = recur(dp, s, p, i+1, pIndex+1);
        }
        else if (p.charAt(pIndex) == s.charAt(i)) {
            return dp[i][pIndex] = recur(dp, s, p, i+1, pIndex+1);
        }
        
        return dp[i][pIndex] = false;
    }

    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return recur(dp, s, p, 0, 0);
    }
}
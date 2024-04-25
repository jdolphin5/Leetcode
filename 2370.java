class Solution {
    private int recur(Integer[][] dp, String s, int k, int i, char c) {
        if (i == s.length()) {
            return 0;
        }

        if (dp[i][c] != null) {
            return dp[i][c];
        }

        int take = 0;
        int leave = 0;

        if (Math.abs(c - s.charAt(i)) <= k || c == '?') {
            take = 1 + recur(dp, s, k, i+1, s.charAt(i));
        }

        leave = recur(dp, s, k, i+1, c);

        return dp[i][c] = Math.max(take, leave);
    }

    public int longestIdealString(String s, int k) {
        Integer[][] dp = new Integer[s.length()][130];

        return recur(dp, s, k, 0, '?');
    }
}
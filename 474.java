class Solution {
    private int recur(Integer[][][] dp, int[] mCount, int[] nCount, int m, int n, int i) {
        if (m < 0 || n < 0) {
            return Integer.MIN_VALUE;
        }

        if (i == mCount.length) {
            return 0;
        }

        if (dp[i][m][n] != null) {
            return dp[i][m][n];
        }

        int take = 1 + recur(dp, mCount, nCount, m-mCount[i], n-nCount[i], i+1);
        int leave = recur(dp, mCount, nCount, m, n, i+1);

        return dp[i][m][n] = Math.max(take, leave);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[] mCount = new int[strs.length];
        int[] nCount = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int zeros = 0;
            int ones = 0;
            
            for (int j = 0; j < strs[i].length(); j++) {
                char c = s.charAt(j);

                if (c == '0') {
                    zeros++;
                }
                else if (c == '1') {
                    ones++;
                }
            }

            mCount[i] = zeros;
            nCount[i] = ones;
        }

        Integer[][][] dp = new Integer[strs.length][m+1][n+1];

        return recur(dp, mCount, nCount, m, n, 0);
    }
}
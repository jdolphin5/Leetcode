class Solution {
    private int recur(Integer[][] dp, int n, int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }

        if (start == end) {
            return 0;
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        int ret = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            int maxOfLowerOrHigher = Math.max(recur(dp, n, i+1, end), recur(dp, n, start, i-1));
            int maxGuess = maxOfLowerOrHigher + i;
            ret = Math.min(ret, maxGuess);
        }

        return dp[start][end] = ret;
    }

    public int getMoneyAmount(int n) {
        Integer[][] dp = new Integer[n+1][n+1];

        return recur(dp, n, 1, n);
    }
}
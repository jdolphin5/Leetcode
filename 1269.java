class Solution {
    private int recur(Integer[][] dp, int index, int stepsRem, int arrLen) {
        final int MOD = 1000000007;

        if (index == 0 && stepsRem == 0) {
            return 1;
        }
        else if (index < 0 || index >= arrLen || stepsRem == 0) {
            return 0;
        }

        if (dp[stepsRem][index] != null) {
            return dp[stepsRem][index];
        }

        int val = 0;

        //go right
        val += recur(dp, index+1, stepsRem-1, arrLen);
        val %= MOD;

        //stay
        val += recur(dp, index, stepsRem-1, arrLen);
        val %= MOD;

        //go left
        val += recur(dp, index-1, stepsRem-1, arrLen);
        val %= MOD;

        return dp[stepsRem][index] = val;
    }

    public int numWays(int steps, int arrLen) {
        if (steps == 1) {
            return 1;
        }

        Integer[][] dp = new Integer[501][501]; //steps remaining, how far away from index 0
        return recur(dp, 0, steps, arrLen); 
    }
}
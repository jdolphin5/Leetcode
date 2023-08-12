class Solution {
    private int helper(int[] dp, int[] arr, int k, int index) {
        //System.out.println("index: " + index + " cur: " + cur);
        if (index == arr.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int ret = 0;

        for (int i = 1; i <= k; i++) {
            int curMax = 0;
            int j = 0;
            for (j = 0; j < i && index+j < arr.length; j++) {
                curMax = Math.max(curMax, arr[index+j]);
            }
            int take = helper(dp, arr, k, index+j) + (j *curMax);
            ret = Math.max(ret, take);
        }
        
        return dp[index] = ret;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        return helper(dp, arr, k, 0);
    }
}
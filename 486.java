class Solution {
    private int helper(int[][] dp, int[] nums, int i, int j) {
        if (i >= j) {
            return nums[i];
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int left = nums[i] - helper(dp, nums, i+1, j);
        int right = nums[j] - helper(dp, nums, i, j-1);
        return Math.max(left, right);
    }

    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return helper(dp, nums, 0, nums.length-1) >= 0;
    }
}
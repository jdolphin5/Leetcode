class Solution {

    private int helper(int[][] dp, int[] nums, int target, int i, int curSum, int total) {
        if (i >= nums.length) {
            if (curSum-total == target) return 1;
            return 0;
        }
        if (dp[i][curSum] != Integer.MIN_VALUE) {
            return dp[i][curSum];
        }

        return dp[i][curSum] = helper(dp, nums, target, i+1, curSum+nums[i], total) + helper(dp, nums, target, i+1, curSum-nums[i], total);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2*total+1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return helper(dp, nums, target, 0, total, total);
    }
}
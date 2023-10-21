class Solution {
    private long recur(Long[][] dp, int[] nums, int i, boolean isAdd) {
        int isAddInt = isAdd ? 0 : 1;

        if (i >= nums.length) {
            return 0;
        }

        if (dp[i][isAddInt] != null) {
            return dp[i][isAddInt];
        }

        long take = 0;
        
        if (isAdd) {
            take = nums[i] + recur(dp, nums, i+1, !isAdd);
        }
        else {
            take = 0 - nums[i] + recur(dp, nums, i+1, !isAdd);
        }

        long leave = recur(dp, nums, i+1, isAdd);

        return dp[i][isAddInt] = Math.max(take, leave);
    }

    public long maxAlternatingSum(int[] nums) {
        Long[][] dp = new Long[nums.length][2];

        return recur(dp, nums, 0, true);
    }
}
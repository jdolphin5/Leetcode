class Solution {
    
    private int recur(Integer[][] dp, List<Integer> nums, int rem, int i) {
        if (rem == 0) {
            return 0;
        }
        
        if (i == nums.size() || rem < 0) {
            return Integer.MIN_VALUE;
        }
        
        if (dp[i][rem] != null) {
            return dp[i][rem];
        }
        
        int take = 1 + recur(dp, nums, rem-nums.get(i), i+1);
        int leave = recur(dp, nums, rem, i+1);
        
        return dp[i][rem] = Math.max(take, leave);
    }
    
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        Integer[][] dp = new Integer[nums.size()][target+1];
        
        int ret = recur(dp, nums, target, 0);
        
        return ret < 0 ? -1 : ret;
    }
}
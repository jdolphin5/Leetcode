class Solution {
    
    private boolean helper(Boolean[][][] dp, List<Integer> nums, int m, int sum, int i, int j, int calls) {
        if (i == j) return true;
        if (sum < m && calls > 0) return false;
        if ((dp[i][j][0] != null) || (dp[i][j][1] != null)) {
            return dp[i][j][0] || dp[i][j][1];
        }
        
        dp[i][j][0] = helper(dp, nums, m, sum-nums.get(j), i, j-1, calls+1);
        dp[i][j][1] = helper(dp, nums, m, sum-nums.get(i), i+1, j, calls+1);
        
        return dp[i][j][0] || dp[i][j][1];
        
        
    }
    
    public boolean canSplitArray(List<Integer> nums, int m) {
        Boolean[][][] dp = new Boolean[nums.size()][nums.size()][2];
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        if (nums.size() == 1) return true;
        
        return helper(dp, nums, m, sum, 0, nums.size()-1, 0);
    }
}
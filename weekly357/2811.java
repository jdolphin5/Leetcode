class Solution {
    
    private boolean helper(Boolean[][] dp, List<Integer> nums, int m, int sum, int i, int j) {
        
        if (i == j) return true;
        if (sum < m) return false;
        
        if ((dp[i][j] != null)) {
            return dp[i][j];
        }
    
        return dp[i][j] =   helper(dp, nums, m, sum-nums.get(j), i, j-1) || 
                            helper(dp, nums, m, sum-nums.get(i), i+1, j);
        
    }
    
    public boolean canSplitArray(List<Integer> nums, int m) {
        Boolean[][] dp = new Boolean[nums.size()][nums.size()];
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        if (nums.size() <= 2) return true;
        
        return helper(dp, nums, m, sum, 0, nums.size()-1);
    }
}
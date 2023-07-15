class Solution {
    
    private int solve(int[] dp, int[] nums, int target, int i) {
        if (i == nums.length-1) {
            return 0;
        }
        
        if (dp[i] != -1) {
            return dp[i];
        }
        
        int ans = Integer.MIN_VALUE;
        
        for (int x = i + 1; x < nums.length; x++) {
            if (Math.abs(nums[i]-nums[x]) <= target) {
                ans = Math.max(ans, 1 + solve(dp, nums, target, x));
            }
        }
        
        return dp[i] = ans;
        
    }
    
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        
        Arrays.fill(dp, -1);
        
        int ans = solve(dp, nums, target, 0);
        
        return ans < 0 ? -1 : ans;
        
    }
}
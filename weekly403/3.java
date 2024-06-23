class Solution {
    private long recur(Long[][] dp, int[] nums, int i, boolean pos, int ct) {
        if (i == nums.length) {
            return 0;
        }
        
        //System.out.println("i: " + i + "pos: " + pos);
        
        if (dp[i][pos ? 1 : 0] != null) {
            return dp[i][pos ? 1 : 0];
        }
        
        long newSubArr = nums[i] + recur(dp, nums, i+1, false, 0);
        long prevSubArr = Integer.MIN_VALUE;
        
        if (!pos) {
            prevSubArr = (-1 * nums[i]) + recur(dp, nums, i+1, true, ct+1);
        }
        
        return dp[i][pos ? 1 : 0] = Math.max(newSubArr, prevSubArr);
    }
    
    public long maximumTotalCost(int[] nums) {
        Long[][] dp = new Long[nums.length][2];
        
        long ret = recur(dp, nums, 0, true, 0);
        
        //System.out.println(Arrays.toString(dp));
        
        return ret;
    }
}
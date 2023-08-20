class Solution {
    private int helper(int[][] dp, List<Integer> nums, int i, int last) {
        if (i == nums.size()) {
            return 0;
        }
        
        if (dp[i][last] != -1) {
            return dp[i][last];
        }
        
        int leave = Integer.MAX_VALUE;
        
        int take = 1 + helper(dp, nums, i+1, last);
        if (nums.get(i) >= last)
            leave = helper(dp, nums, i+1, nums.get(i));
        
        return dp[i][last] = Math.min(take, leave);
        
    }
    
    public int minimumOperations(List<Integer> nums) {
        if (nums.size() == 1) return 0;
        int[][] dp = new int[nums.size()][4];
        
        for (int[] arr1 : dp)
            Arrays.fill(arr1, -1);
        
        int ret = helper(dp, nums, 0, 0);
        //System.out.println(Arrays.toString(dp));
        return ret;
    }
}
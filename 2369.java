class Solution {

    private boolean helper(Boolean[] dp, int[] nums, int i) {
        if (i > nums.length) return false;
        if (i == nums.length) return true;

        //System.out.println("i: " + i + " j: " + j);

        if (dp[i] != null) {
            return dp[i];
        }

        boolean checkTwo = false;
        boolean checkThree = false;
        if (i+1 < nums.length && nums[i] == nums[i+1]) {
            checkTwo = true;
        }
        if (i+2 < nums.length && nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) {
            checkThree = true;
        }
        if (i+2 < nums.length && nums[i] == nums[i+1]-1 && nums[i+1] == nums[i+2]-1) {
            checkThree = true;
        }

        return dp[i] = (checkTwo && helper(dp, nums, i+2)) || (checkThree && helper(dp, nums, i+3));

         
    }

    public boolean validPartition(int[] nums) {

        Boolean[] dp = new Boolean[nums.length];

        return helper(dp, nums, 0);
    }
}
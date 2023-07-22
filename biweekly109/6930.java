class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 1) {
            return false;
        }
        if (nums[nums.length-1] == nums[nums.length-2] && nums[nums.length-1] == nums.length-1) {
            return true;
        }
        return false;
    }
}
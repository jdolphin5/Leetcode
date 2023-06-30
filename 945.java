class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int last = -1;
        int ret = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                int diff = nums[i-1] - nums[i];
                nums[i] += diff + 1;
                ret += diff + 1;
            }
        }
        return ret;

    }
}
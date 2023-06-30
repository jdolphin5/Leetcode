class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int last = -1;
        int ret = 0;
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] <= nums[i-1]) {
                nums[i]++;
                ret++;
            }
        }
        return ret;

    }
}
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int ret = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++) {
            ret = Math.max(ret, nums[i+1]-nums[i]);
        }

        return ret;
    }
}
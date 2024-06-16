class Solution {
    public int minPatches(int[] nums, int n) {
        Arrays.sort(nums);

        long x = 1;
        int i = 0;
        int ret = 0;

        while (x <= n) {
            if (i < nums.length && nums[i] <= x) {
                x += nums[i];
                i++;
            }
            else {
                x += x;
                ret++;
            }
        }

        return ret;
    }
}
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ret = 1;
        int i = 1;
        int a = k;
        int x = nums[0];
        while (i < nums.length) {
            if (nums[i] - x <= a) {
                //place number
                a = a - (nums[i] - x);
            }
            else {
                ret++;
                a = k;
            }
            x = nums[i];
            i++;
        }
        return ret;
    }
}
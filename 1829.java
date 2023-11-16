class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int totalXor = 0;
        int[] ret = new int[nums.length];


        for (int num : nums) {
            totalXor ^= num;
        }

        int maxK = (int)(Math.pow(2, maximumBit) - 1);

        for (int i = nums.length-1; i >= 0; i--) {
            ret[nums.length-1-i] = maxK ^ totalXor;
            totalXor ^= nums[i];
        }

        return ret;
    }
}
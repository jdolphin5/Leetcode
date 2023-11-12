class Solution {
    public int longestSubarray(int[] nums) {
        //find the longest length of the maximum value occuring in nums
        
        int max = 0;
        int ret = 1;
        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                ret = 1;
                len = 1;
            }
            else if (nums[i] == max) {
                len++;
                ret = Math.max(ret, len);
            }
            else {
                len = 0;
            }
        }

        return ret;
    }
}
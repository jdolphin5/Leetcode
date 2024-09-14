class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int ret = 0;
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[j] == max) {
                j++;
                ret = Math.max(ret, j - i);
            } else {
                j++;
                i = j;
            }
        }

        return ret;
    }
}
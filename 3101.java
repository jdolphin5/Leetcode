class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long ret = 0;

        int i = 0;
        int j = 0;
        int last = nums[0] == 1 ? 0 : 1;

        while (j < nums.length) {
            if (nums[j] != last) {
                last = nums[j];
                j++;

                ret += j - i;
            }
            else {
                i = j;
                last = last == 1 ? 0 : 1;
            }
        }

        return ret;
    }
}
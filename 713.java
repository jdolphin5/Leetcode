class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ret = 0;

        if (k == 0) return 0;

        for (int i = 0; i < nums.length; i++) {
            int prod = 1;

            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                if (prod < k) ret++;
                else
                    break;
            }
        }

        return ret;
    }
}
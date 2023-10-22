class Solution {
    public int maximumScore(int[] nums, int k) {
        int ret = nums[k];
        int minVal = nums[k];
        int i = k;
        int j = k;
        int n = nums.length;

        while (i > 0 || j < n-1) {
            if (i == 0 || (j < n-1 && nums[j+1] > nums[i-1])) {
                j++;
            }
            else {
                i--;
            }
            
            minVal = Math.min(minVal, Math.min(nums[i], nums[j]));
            ret = Math.max(ret, (j - i + 1) * minVal);
        }

        return ret;
    }
}
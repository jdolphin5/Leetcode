class Solution {
    public int maxWidthRamp(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int ret = 0;
        
        while (i < nums.length) {
            while (j > i) {
                if (nums[j] >= nums[i]) {
                    ret = Math.max(ret, j - i);
                    break;
                }
                j--;
            }

            i++;
            j = nums.length-1;

            if (ret >= j - i) {
                break;
            }
        }

        return ret;
    }
}
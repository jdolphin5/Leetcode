class Solution {
    public int wiggleMaxLength(int[] nums) {
        boolean higher = true;
        boolean first = true;
        int len = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (first) {
                if (nums[i] - nums[i-1] > 0) {
                    higher = true;
                    first = false;
                }
                else if (nums[i] - nums[i-1] < 0) {
                    higher = false;
                    first = false;
                }
                else {
                    len--;
                }
            }
            else {
                if (higher) {
                    if (nums[i] - nums[i-1] < 0) {
                        higher = false;
                    }
                    else {
                        len--;
                    }
                }
                else {
                    if (nums[i] - nums[i-1] > 0) {
                        higher = true;
                    }
                    else {
                        len--;
                    }
                }
            }
        }
        return len;
    }
}
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            int runningOr = 0;
            
            for (int j = i; j < nums.length; j++) {
                if ((nums[j] & runningOr) != 0) {
                    break;
                }
                else {
                    runningOr |= nums[j];
                    ret = Math.max(ret, j - i + 1);
                }
            }
        }

        return ret;
    }
}
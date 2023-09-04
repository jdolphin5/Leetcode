class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);

        int ret = 0;
        long sum = 0;

        for (int i = nums.length-1; i >= 0; i--) {
            sum += nums[i];
            
            if (sum > 0) {
                ret++;
            }
            else {
                break;
            }
        }

        return ret;
    }
}
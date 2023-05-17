class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        boolean possible = false;

        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                minLen = Math.min(minLen, j-i+1);
                possible = true;
                sum -= nums[i];
                i++;
            }
            j++;
        }

        if (!possible) return 0;
        return minLen;
    }
}
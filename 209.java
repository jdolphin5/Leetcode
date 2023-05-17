class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        boolean possible = false;

        while (j < nums.length || sum >= target) {
            if (sum < target) {
                sum += nums[j];
                j++;
            } else {
                minLen = Math.min(minLen, j-i);
                possible = true;
                sum -= nums[i];
                i++;
            }
        }

        if (!possible) return 0;
        return minLen;
    }
}
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        long total = 0;
        int maxFreq = 1;
        while (j < nums.length) {
            total += nums[j];
            while ((long)nums[j]*(j-i+1) > total+k) {
                total -= nums[i];
                i++;
            }
            maxFreq = Math.max(maxFreq, j - i + 1);
            j++;
        }
        return maxFreq;
    }
}
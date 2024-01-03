class Solution {
    public int minSwaps(int[] nums) {
        int onesCount = 0;

        for (int num : nums) {
            if (num == 1) onesCount++;
        }

        int i = 0;
        int j = 0;
        
        int windowOnes = 0;
        int maxWindowOnes = 0;

        while (j < nums.length + onesCount - 1) {
            if (j - i < onesCount) {
                windowOnes += nums[j % nums.length];
                j++;
                maxWindowOnes = Math.max(maxWindowOnes, windowOnes);
            }
            else {
                windowOnes -= nums[i % nums.length];
                i++; 
            }
        }

        return onesCount - maxWindowOnes;
    }
}
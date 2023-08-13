class Solution {
    public int maxSum(int[] nums) {
        int[] maxDigits = new int[nums.length];
        int[] numsCopy = nums.clone();
        
        for (int i = 0; i < nums.length; i++) {
            while (numsCopy[i] != 0) {
                maxDigits[i] = Math.max(maxDigits[i], numsCopy[i] % 10);
                numsCopy[i] /= 10;
            }
        }
        
        int max = -1;
        for (int i = 0; i < maxDigits.length; i++) {
            for (int j = i+1; j < maxDigits.length; j++) {
                if (maxDigits[j] == maxDigits[i]) {
                    max = Math.max(nums[i] + nums[j], max);
                }
            }
        }
        return max;
    }
}
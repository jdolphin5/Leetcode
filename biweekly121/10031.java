class Solution {
    public int missingInteger(int[] nums) {
        int sumOfLongestPrefix = 0;
        int sum = 0;
        int last = nums[0]-1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == last + 1) {
                sum += nums[i];
            }
            else {
                break;
            }
            last = nums[i];
            
            sumOfLongestPrefix = Math.max(sumOfLongestPrefix, sum);
        }
        
        for (int x = sumOfLongestPrefix; ; x++) {
            boolean contained = false;
            
            for (int i = 0; i < nums.length; i++) {
                if (x == nums[i]) {
                    contained = true;
                    break;
                }
            }
            
            if (!contained) {
                return x;
            }
        }
    }
}
class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int[] patternArr = new int[nums.length-1];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                patternArr[i-1] = 1;
            }
            else if (nums[i] == nums[i-1]) {
                patternArr[i-1] = 0;
            }
            else {
                patternArr[i-1] = -1;
            }
        }
        
        int ret = 0;
        
        for (int i = 0; i < patternArr.length+1-pattern.length; i++) {
            boolean good = true;
            
            for (int j = 0; j < pattern.length; j++) {
                if (patternArr[i+j] != pattern[j])
                    good = false;
            }
            
            if (good) ret++;
        }
        
        return ret;
    }
}
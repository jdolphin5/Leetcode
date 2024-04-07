class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ret = 0;
        int last = 0;
        int len1 = 0;
        int len2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (ret == 0) {
                len1++;
                len2++;
            }
            else if (nums[i] > last) {
                len1++;
                len2 = 1;
            }
            else if (nums[i] < last) {
                len1 = 1;
                len2++;
            }
            else {
                len1 = 1;
                len2 = 1;
            }
                
                
            last = nums[i];
        
            
            ret = Math.max(ret, len1);
            ret = Math.max(ret, len2);
        }
        
        return ret;
    }
}
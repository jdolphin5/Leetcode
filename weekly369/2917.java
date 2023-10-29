class Solution {
    public int findKOr(int[] nums, int k) {
        int[] bitSetCount = new int[31];
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (((int)Math.pow(2, i) & nums[j]) > 0) {
                    bitSetCount[i]++;
                }
            }
        }
        
        int ret = 0;
        
        for (int i = 0; i < 31; i++) {
            if (bitSetCount[i] >= k) { 
                ret += Math.pow(2, i);
            }
        }
        
        return ret;
    }
}
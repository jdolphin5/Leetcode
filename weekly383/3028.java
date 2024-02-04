class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int ret = 0;
        
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
            if (sum == 0) {
                ret++;
            }
        }
        
        return ret;
    }
}
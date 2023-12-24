class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        
        int[] ret = new int[nums.length];
        
        int i = 0;
        int j = 0;
        
        while (i < nums.length) {
            ret[i++] = nums[j+1];
            ret[i++] = nums[j];
            j+=2;
        }
        
        return ret;
    }
}
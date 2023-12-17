class Solution {
    public int[][] divideArray(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int[][] ret = new int[nums.length/3][3];
        
        
        for (int i = 0; i < nums.length; i+=3) {
            if (nums[i+2] - nums[i] > k) {
                return new int[][] {};
            }
            else {
                ret[i/3][0] = nums[i];
                ret[i/3][1] = nums[i+1];
                ret[i/3][2] = nums[i+2];
            }
        }
        
        return ret;
    }
}
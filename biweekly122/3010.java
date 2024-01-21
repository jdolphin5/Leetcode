class Solution {
    public int minimumCost(int[] nums) {
        int ret = 0;
        
        ret += nums[0];
        
        int[] nums2 = new int[nums.length-1];
        
        for (int i = 1; i < nums.length; i++) {
            nums2[i-1] = nums[i];
        }
        
        Arrays.sort(nums2);
        
        ret += nums2[0] + nums2[1];
        
        return ret;
    }
}
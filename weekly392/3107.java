class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {

        Arrays.sort(nums);
        
        int len = nums.length;
        long ret = 0;
        

        int i = len/2;

        while (i < nums.length && k > nums[i]) {
            ret += k-nums[i];
            i++;
        }

        i = len/2;

        while (i >= 0 && k < nums[i]) {
            ret += nums[i] - k;
            i--;
        }
        
        return ret;
        
    }
}

//1,2,500,500,5,6
class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long nums1ZeroCount = 0;
        long nums2ZeroCount = 0;
        long nums1Sum = 0;
        long nums2Sum = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                nums1ZeroCount++;
            }
            nums1Sum += nums1[i];
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0) {
                nums2ZeroCount++;
            }
            nums2Sum += nums2[i];
        }
        
        long nums1MinimumSum = nums1Sum + nums1ZeroCount;
        long nums2MinimumSum = nums2Sum + nums2ZeroCount;
        
        long minimumSum = Math.max(nums1MinimumSum, nums2MinimumSum);
        
        if (nums1ZeroCount == 0 && nums1MinimumSum < nums2MinimumSum) {
            return -1;
        }
        
        if (nums2ZeroCount == 0 && nums2MinimumSum < nums1MinimumSum) {
            return -1;
        }
        
        return minimumSum;
    }
}
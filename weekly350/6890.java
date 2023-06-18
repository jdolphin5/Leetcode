class Solution {
    public int findValueOfPartition(int[] nums) {
        // min of nums2
        // max of nums1
        // get those values close to each other
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            minDiff = Math.min(minDiff, nums[i+1]-nums[i]);
        }
        return minDiff;
    }
}
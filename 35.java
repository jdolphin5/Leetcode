class Solution {
    public int searchInsert(int[] nums, int target) {
        int upper = nums.length-1;
        int lower = 0;
        while (lower <= upper) {
            int mid = lower + (upper - lower) / 2;
            if (nums[mid] < target) {
                lower = mid+1;
            }
            else if (nums[mid] > target) {
                upper = mid-1;
            }
            else {
                return mid;
            }
        }
        return lower;
    }
}
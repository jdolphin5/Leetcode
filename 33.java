class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int lower = 0;
        int upper = nums.length -1;

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (nums[mid] > nums[upper]) {
                lower = mid + 1;
            }
            else {
                upper = mid;
            }
        }

        int start = lower;
        lower = 0;
        upper = nums.length-1;

        if (target >= nums[start] && target <= nums[upper]) {
            lower = start;
        }
        else {
            upper = start;
        }

        while (lower <= upper) {
            int mid = lower + (upper - lower) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                lower = mid + 1;
            }
            else {
                upper = mid - 1;
            }
        }

        return -1;
        
    }
}
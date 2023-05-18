class Solution {

    private int binarySearch(int[] nums, int lower, int upper, int min) {
        int mid = (upper + lower) / 2;

        if (nums[mid] > min) {
            return binarySearch(nums, mid+1, upper, min);
        }
        else if (nums[mid] < min) {
            min = nums[mid];
            return binarySearch(nums, lower, mid, min);
        }
        else {
            return min;
        }
    }

    public int findMin(int[] nums) {
        int min = 0;
        
        if (nums[0] < nums[nums.length-1]) {
            return nums[0];
        }
        else {
            min = nums[nums.length-1];
        }

        min = binarySearch(nums, 0, nums.length-1, min);

        return min;
    }
}
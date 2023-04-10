class Solution {

    private static int binarySearch(int[] nums, int target, int lower, int upper) {
        if (lower >= upper) return -1;
        int i = (lower + upper) / 2;
        if (target == nums[i]) {
            return i;
        }
        else if (target < nums[i]) {
            return binarySearch(nums, target, lower, upper-1);
        }
        else {
            return binarySearch(nums, target, lower+1, upper);
        }
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length);
    }
}
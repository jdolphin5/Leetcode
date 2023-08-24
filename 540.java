class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lower = 0;
        int upper = nums.length;

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
        
            if (mid % 2 == 1)
                mid--;
        
            if (mid+1 < nums.length && nums[mid] != nums[mid+1]) {
                upper = mid;
            }
            else if (mid+1 < nums.length && nums[mid] == nums[mid+1]) {
                lower = mid+2;
            }
            else { //else block executes if lower == nums.length-1 && upper == nums.length
                break;
            }
        }

        return nums[lower];
    }
}
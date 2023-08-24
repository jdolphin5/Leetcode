class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lower = 0;
        int upper = nums.length;

        int index = -1;
        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;

            if (nums[mid] == target) {
                index = mid;
                break;
            }
            else if (nums[mid] < target) {
                lower = mid+1;
            }
            else {
                upper = mid;
            }
        }
        if (index == -1) {
            return new int[] {-1, -1};
        }

        int i = index;
        int j = index;
        while (i-1 >= 0 && nums[i-1] == target) {
            i--;
        }

        while (j+1 <= nums.length-1 && nums[j+1] == target) {
            j++;
        }

        return new int[] {i, j};
    }
}
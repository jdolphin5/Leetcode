class Solution {
    private boolean canFormPairs(int[] nums, int checkDiff, int p) {
        int i = 0;
        int count = 0;
        while (i < nums.length-1) {
            if (nums[i+1] - nums[i] <= checkDiff) {
                count++;
                i++;
            }
            i++;
        }
        return count >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int lower = 0;
        int upper = nums[nums.length-1]-nums[0];

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (canFormPairs(nums, mid, p)) {
                upper = mid;
            }
            else {
                lower = mid+1;
            }
        }

        return lower;
    }
}
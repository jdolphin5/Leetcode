class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int[] minimumAfterIndex = new int[nums.length];
        int min = Integer.MAX_VALUE;

        for (int i = nums.length-1; i >= 0; i--) {
            minimumAfterIndex[i] = min;
            min = Math.min(min, nums[i]);
        }

        for (int i = 0; i < nums.length-1; i++) {
            if (minimumAfterIndex[i+1] < nums[i]) {
                return false;
            }
        }

        return true;
    }
}
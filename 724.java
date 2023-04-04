class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                right += nums[j];
            }
            if (left == right) return i;
            left += nums[i];
            right = 0;
        }
        return -1;
    }
}
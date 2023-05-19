class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length+1; i++) {
            if (i < nums.length && nums[i] != i) {
                return i;
            }
            else if (i == nums.length) {
                return i;
            }
        }
        return -1;
    }
}
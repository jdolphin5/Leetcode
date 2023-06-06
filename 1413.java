class Solution {
    public int minStartValue(int[] nums) {
        int lowest = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            lowest = Math.min(sum, lowest);
        }
        return Math.abs(lowest)+1;
    }
}
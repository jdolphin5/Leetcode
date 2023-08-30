class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int goalNum = nums[nums.length/2];

        int totalDiff = 0;

        for (int num : nums) {
            totalDiff += Math.abs(goalNum - num);
        }

        return totalDiff;
    }
}
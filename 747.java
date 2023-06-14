class Solution {
    public int dominantIndex(int[] nums) {
        int[] max = new int[2];
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max[1]) {
                if (nums[i] > max[0]) {
                    max[1] = max[0];
                    max[0] = nums[i];
                    maxIndex = i;
                }
                else {
                    max[1] = nums[i];
                }
            }
        }
        if (max[0] >= 2*max[1]) return maxIndex;
        return -1;

    }
}
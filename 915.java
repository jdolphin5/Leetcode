class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] maxBefore = new int[nums.length];
        int[] minAfter = new int[nums.length];

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            maxBefore[i] = max;    
        }

        int min = Integer.MAX_VALUE;

        for (int i = nums.length-1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minAfter[i] = min;
        }

        int ret = 0;

        for (int i = nums.length-1; i >= 1; i--) {
            if (maxBefore[i-1] <= minAfter[i]) {
                ret = i;
            }
        }

        return ret;
    }
}
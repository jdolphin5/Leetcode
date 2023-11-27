class Solution {
    public int[] getAverages(int[] nums, int k) {
        double[] prefixSum = new double[nums.length];
        double runningTotal = 0;

        for (int i = 0; i < nums.length; i++) {
            runningTotal += (double)nums[i];
            prefixSum[i] = runningTotal;
        }

        int[] ret = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i - k < 0 || i + k >= nums.length) {
                ret[i] = -1;
            }
            else {
                if (i-k-1 < 0)
                    ret[i] = (int)(prefixSum[i+k] / ((2 * k) + 1));
                else
                    ret[i] = (int)((prefixSum[i+k] - prefixSum[i-k-1]) / ((2 * k) + 1));
            }
        }

        return ret;
    }
}
class Solution {
    private int recur(Integer[][] dp, int[] nums1, int[] nums2, int i, int lastNums1, int lastNums2, int swap) {
        if (i == nums1.length) {
            return 0;
        }

        if (dp[i][swap] != null) {
            return dp[i][swap];
        }

        int leave = nums1.length;
        int take = nums1.length;

        if (nums1[i] > lastNums1 && nums2[i] > lastNums2) {
            leave = recur(dp, nums1, nums2, i+1, nums1[i], nums2[i], 0);
        }

        if (nums2[i] > lastNums1 && nums1[i] > lastNums2) {
            take = 1 + recur(dp, nums1, nums2, i+1, nums2[i], nums1[i], 1);
        }

        return dp[i][swap] = Math.min(take, leave);
    }

    public int minSwap(int[] nums1, int[] nums2) {
        Integer[][] dp = new Integer[nums1.length][2];

        return recur(dp, nums1, nums2, 0, -1, -1, 0);
    }
}
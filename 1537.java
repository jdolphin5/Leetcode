class Solution {
    private long recur1(Long[] dp1, Long[] dp2, int[] nums1, int[] nums2, Map<Integer, Integer> nums1Map, Map<Integer, Integer> nums2Map, int i) {
        if (i == nums1.length) {
            return 0;
        }

        if (dp1[i] != null) {
            return dp1[i];
        }

        long ret = nums1[i] + recur1(dp1, dp2, nums1, nums2, nums1Map, nums2Map, i+1);

        if (nums2Map.containsKey(nums1[i])) {
            ret = Math.max(ret, nums1[i] + recur2(dp1, dp2, nums1, nums2, nums1Map, nums2Map, nums2Map.get(nums1[i]) + 1));
        }

        return dp1[i] = ret;
    }

    private long recur2(Long[] dp1, Long[] dp2, int[] nums1, int[] nums2, Map<Integer, Integer> nums1Map, Map<Integer, Integer> nums2Map, int i) {
        if (i == nums2.length) {
            return 0;
        }

        if (dp2[i] != null) {
            return dp2[i];
        }

        long ret = nums2[i] + recur2(dp1, dp2, nums1, nums2, nums1Map, nums2Map, i+1);

        if (nums1Map.containsKey(nums2[i])) {
            ret = Math.max(ret, nums2[i] + recur1(dp1, dp2, nums1, nums2, nums1Map, nums2Map, nums1Map.get(nums2[i]) + 1));
        }

        return dp2[i] = ret;
    }

    public int maxSum(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        long ret = 0;

        Long[] dp1 = new Long[nums1.length];
        Long[] dp2 = new Long[nums2.length];
        Map<Integer, Integer> nums1Map = new HashMap<>();
        Map<Integer, Integer> nums2Map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            nums1Map.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2Map.put(nums2[i], i);
        }

        ret = recur1(dp1, dp2, nums1, nums2, nums1Map, nums2Map, 0);
        ret = Math.max(ret, recur2(dp1, dp2, nums1, nums2, nums1Map, nums2Map, 0));

        return (int)(ret % MOD);
    }
}
class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long negK = 0;
        long posK = 0;

        if (k == 0) {
            return Arrays.equals(nums1, nums2) ? 0 : -1;
        }

        for (int i = 0; i < nums1.length; i++) {
            int diff = nums2[i] - nums1[i]; 

            if (diff % k != 0) return -1;

            if (diff < 0) {
                negK += Math.abs(diff) / k;
            }
            else {
                posK += diff / k;
            }
        }

        if (negK != posK) {
            return -1;
        }

        return posK;
    }
}
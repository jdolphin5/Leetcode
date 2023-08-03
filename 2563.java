class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ret = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++) {

            int left = i+1;
            int right = nums.length;

            while (left < right) {

                int mid = left + (right - left) / 2;
                int sum = nums[i] + nums[mid];

                if (sum < lower) {
                    left = mid+1;
                }
                else {
                    right = mid;
                }
            }

            int goodLeft = left;
            left = i+1;
            right = nums.length;

            while (left < right) {

                int mid = left + (right - left) / 2;
                int sum = nums[i] + nums[mid];
                if (sum > upper) {
                    right = mid;
                }
                else {
                    left = mid+1;
                }
            }

            int goodRight = left;
            ret += (goodRight - goodLeft);

        }
        return ret;
    }
}
class Solution {
    private int canMake(int[] nums, int check) {
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] - nums[i] <= check)
                    ret++;
                else
                    break;
            }
        }

        return ret;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int lower = 0;
        int upper = 1000000; //10^6

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;

            if (canMake(nums, mid) < k) {
                lower = mid+1;
            }
            else {
                upper = mid;
            }
        }

        return lower;
    }
}
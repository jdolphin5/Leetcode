class Solution {
    private boolean checkNums(int[] nums) {
        for (int num : nums) {
            if (num != 0)
                return false;
        }

        return true;
    }

    private int traverse(int i, int[] nums, boolean dir) {
        if (!dir) {
            i--;
        } else {
            i++;
        }
        if (checkNums(nums)) {
            return 1;
        }
        if (i < 0 || i == nums.length) {
            return 0;
        }

        if (nums[i] == 0) {
            return traverse(i, nums, dir);
        } else {
            nums[i]--;
            return traverse(i, nums, !dir);
        }
    }

    public int countValidSelections(int[] nums) {
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int[] copy = nums.clone();
                int[] copy2 = nums.clone();

                int j = i;
                int k = i;

                // j - left, k - right

                ret += traverse(j, copy, false);
                ret += traverse(k, copy2, true);
            }
        }

        return ret;
    }
}
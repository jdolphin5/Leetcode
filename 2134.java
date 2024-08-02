class Solution {
    public int minSwaps(int[] nums) {
        int oneCount = 0;

        for (int num : nums) {
            oneCount += num;
        }

        int[] extendedNums = new int[nums.length * 2];

        for (int i = 0; i < nums.length * 2; i++) {
            extendedNums[i] = nums[i % nums.length];
        }

        int ret = 0;
        int x = 0;

        for (int i = 0; i < extendedNums.length; i++) {
            if (i >= oneCount && extendedNums[i - oneCount] == 1) x--;
            if (extendedNums[i] == 1) x++;
            ret = Math.max(ret, x);
        }

        return oneCount - ret;
    }
}
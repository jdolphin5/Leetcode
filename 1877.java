class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int pairSum = 0;

        while (i <= j) {
            pairSum = Math.max(pairSum, nums[i] + nums[j]);
            i++;
            j--;
        }

        return pairSum;
    }
}
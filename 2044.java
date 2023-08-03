class Solution {
    int max = 0;
    int maxCount = 0;

    private void recur(int[] nums, int i, int orVal) {
        if (i == nums.length) {
            return;
        }
        int before = orVal;
        orVal |= nums[i];
        if (orVal == max) {
            maxCount++;
        }
        else if (orVal > max) {
            max = orVal;
            maxCount = 1;
        }
        recur(nums, i+1, orVal);
        recur(nums, i+1, before);
    }

    public int countMaxOrSubsets(int[] nums) {
        
        recur(nums, 0, 0);
        
        return maxCount;
    }
}
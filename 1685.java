class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int total = 0;
        
        for (int num : nums) {
            total += num;
        }

        int i = 0;
        int last = 0;
        int[] ret = new int[nums.length];

        while (i < nums.length) {
            int toAdd = i * (nums[i] - last);
            int toSubtract = (nums[i] - last) * (nums.length - i);
            total = total - toSubtract + toAdd;
            
            ret[i] = total;

            last = nums[i];
            i++;
        }

        return ret;
    }
}
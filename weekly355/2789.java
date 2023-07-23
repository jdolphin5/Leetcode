class Solution {
    public long maxArrayValue(int[] nums) {
        //2147483647
        //100000000000
        
        long[] numsCopy = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsCopy[i] = nums[i];
        }
        
        //nums.length == 3 -> must choose index (0-indexed) < 2
        //can choose 0, 1 (not last element)
        long max = numsCopy[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            if (numsCopy[i] <= numsCopy[i+1]) {
                numsCopy[i] = numsCopy[i] + numsCopy[i+1];
            }
            max = Math.max(max, numsCopy[i]);
        }
        return max;
    }
}
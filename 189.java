class Solution {
    public void rotate(int[] nums, int k) {
        int[] ret = new int[nums.length];
        int arrLenOverK = k / nums.length;

        for (int i = 0; i < nums.length; i++) {
            ret[i] = nums[((i-k+(nums.length*(arrLenOverK+1)))%nums.length)];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = ret[i];
        }
    }
}
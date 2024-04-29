class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        xor ^= k;
        int bitCount = Integer.bitCount(xor);

        return bitCount;
    }
}
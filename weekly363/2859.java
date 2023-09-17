package weekly363;
class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Long.bitCount(i) == k) {
                sum += nums.get(i);
            }
        }

        return (int)sum;
    }
}
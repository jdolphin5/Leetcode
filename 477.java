class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int comp = nums[i] ^ nums[j];
                count += Integer.bitCount(comp);
            }
        }
        return count;
    }
}
class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length*2];
        for (int i = 0; i < nums.length*2; i++) {
            int j = i % nums.length;
            ans[i] = nums[j];
        }

        return ans;
    }
}
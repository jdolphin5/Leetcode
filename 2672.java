class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int count = 0;
        int[] nums = new int[n];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int colour = queries[i][1];
            if (index-1 >= 0) {
                if (nums[index-1] == nums[index] && nums[index] > 0) {
                    count--;
                }
            }
            if (index+1 < nums.length) {
                if (nums[index] == nums[index+1] && nums[index] > 0) {
                    count--;
                }
            }
            nums[index] = colour;
            //System.out.println(Arrays.toString(nums));
            if (index-1 >= 0) {
                if (nums[index-1] == nums[index] && nums[index] > 0) {
                    count++;
                }
            }
            if (index+1 < nums.length) {
                if (nums[index] == nums[index+1] && nums[index] > 0) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
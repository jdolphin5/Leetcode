class Solution {
    public int matrixSum(int[][] nums) {
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        
        for (int j = 0; j < nums[0].length; j++) {
            int colMax = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i][j] > colMax) {
                    colMax = nums[i][j];
                }
            }
            max += colMax;
        }

        return max;
        
    }
}
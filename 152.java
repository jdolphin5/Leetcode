class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int max = Integer.MIN_VALUE;
        int curProd = 0;
        
        for (int i = 0; i < nums.length; i++) {
            curProd = nums[i];
            max = Math.max(curProd, max);
            for (int j = i+1; j < nums.length; j++) {
                curProd = curProd * nums[j];
                max = Math.max(curProd, max);
            }
        }

        return max;
    }
}
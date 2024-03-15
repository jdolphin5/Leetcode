class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int leftProd = 1;
        int rightProd = 1;
        int zeroCount = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCount++;
            else
                rightProd *= nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount >= 2 || (zeroCount == 1 && nums[i] != 0)) {
                ret[i] = 0;
            }
            else {
                if (nums[i] != 0) {
                    rightProd /= nums[i];
                }

                ret[i] = leftProd * rightProd;
                
                if (nums[i] != 0) {
                    leftProd *= nums[i];
                }
            }
        }
        
        return ret;
    }
}
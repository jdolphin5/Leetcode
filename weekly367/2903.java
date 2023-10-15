class Solution {
    
    /*
        abs(i - j) >= indexDifference, and
        abs(nums[i] - nums[j]) >= valueDifference
    /*/
    
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        
        return ret;
        
    }
}
class Solution {
 
    public int semiOrderedPermutation(int[] nums) {
        int count = 0;
        
        while (nums[0] != 1) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = temp;
                    count++;
                }
            }
        }
        while (nums[nums.length-1] != nums.length) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i-1] == nums.length) {
                    int temp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = temp;
                    count++;
                }
            }
        }
        
        return count;
        
    }
}
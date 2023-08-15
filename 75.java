class Solution {
    public void sortColors(int[] nums) {
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i] - nums[i+1] > 0) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
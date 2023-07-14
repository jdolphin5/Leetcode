class Solution {
    public int minDeletion(int[] nums) {
        int removed = 0;
        int totalElements = nums.length;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    removed++;
                    totalElements--;
                }
                else {
                    i = j;
                    break;
                }
                if (j == nums.length-1) i = j;
            }
        }
        if (totalElements % 2 != 0) removed++;
        return removed;
    }
}
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long total = 0;
        
        for (int num : nums) {
            total += num;
        }
        
        double diff = Math.abs(total - goal);
        
        return (int)Math.ceil(diff/limit);
    }
}
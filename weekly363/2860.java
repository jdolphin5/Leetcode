class Solution {
    
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        
        int ret = 0;
        
        int highestTaken = 0;
        int lowestNot = 0;
        int count = 0;
        
        if (nums.get(0) > 0) {
            ret++;
        }
        
        for (int i = 0; i < nums.size()-1; i++) {
            highestTaken = nums.get(i);
            count++;
            
            lowestNot = nums.get(i+1);
            
            if (highestTaken < count && lowestNot > count) {
                ret++;
            }
        }
        
        if (nums.get(nums.size()-1) < nums.size()) {
            ret++;
        }
        
        return ret;
        
    }
}
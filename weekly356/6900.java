class Solution {
    
    private boolean checkVal(Map<Integer, Integer> complete, Map<Integer, Integer> subMap) {
        
        if (complete.size() < subMap.size()) return false;
        
        return true;
        
    }
    
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer, Integer> complete = new HashMap<>();
        for (int num : nums) {
            complete.put(num, 1);
        }
        
        int count = 0;
        Map<Integer, Integer> subMap = new HashMap<>();
        
        int i = 0;
        int j = 0;
        
        while (i < nums.length || j < nums.length) {
            subMap.put(nums[j], subMap.getOrDefault(nums[j], 0) + 1);
            j++;
            while (!checkVal(complete, subMap)) {
                subMap.put(nums[i], subMap.get(nums[i])-1);
                if (subMap.get(nums[i]) == 0) {
                    subMap.remove(nums[i]);
                }
                i++;
            }
            if (complete.keySet().equals(subMap.keySet())) {
                //System.out.println(complete.toString());
                //System.out.println(subMap.toString());
                count++;
            }
            
            if (j >= nums.length) {
                subMap = new HashMap<>();
                i++;
                j = i;
            }
            
        }
        
        return count;
        
    }
}
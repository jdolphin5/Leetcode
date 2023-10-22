class Solution {
    
    private int canMake(List<Integer> myList, int size) {
        int ret = 0;
        
        for (int num : myList) {
            int numGroups = num / (size+1);
            int remaining = num % (size+1);
            
            if (remaining == 0) {
                ret += numGroups;
            }
            else if (numGroups >= size - remaining) {
                ret += numGroups + 1;
            }
            else {
                return -1;
            }
        }
        
        return ret;
    }
    
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<>();
        
        for (int num : nums) {
            myMap.put(num, myMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> myList = new ArrayList<>();
        
        myMap.forEach(
            (key, value)
                -> myList.add(value));
        
        Collections.sort(myList);
        
        int ret = Integer.MAX_VALUE;
        
        for (int i = nums.length; i >= 1; i--) {
            int val = canMake(myList, i);
            
            if (val != -1) {
                ret = Math.min(ret, val);
            }
        }
        
        return ret;
    }
}
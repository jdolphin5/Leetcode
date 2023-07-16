class Solution {
    
    private void incMap(int val, Map<Integer, Integer> myMap) {
        myMap.put(val, myMap.getOrDefault(val, 0) + 1);
    }
    
    private void decMap(int val, Map<Integer, Integer> myMap) { 
        if (myMap.get(val) == 1) {
            myMap.remove(val);
        }
        else {
            myMap.put(val, myMap.get(val)-1);
        }
    }
    
    
    public int minimumIndex(List<Integer> nums) {
        
        if (nums.size() == 1) {
            return -1;
        }
        
        int leftDom = 0;
        int leftCount = 0;
        
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        
        
        // first element in left - remaining in right
        incMap(nums.get(0), leftMap);
        leftDom = nums.get(0);
        leftCount = 1;
        for (int i = 1; i < nums.size(); i++) {
            incMap(nums.get(i), rightMap);
            if (rightMap.containsKey(leftDom) && rightMap.get(leftDom) > (nums.size()-1)/2) {
                return 0;
            }
        }
        
        for (int i = 1; i < nums.size()-1; i++) {
            incMap(nums.get(i), leftMap);
            if (nums.get(i) == leftDom) {
                leftCount++;
            }
            else {
                if (leftMap.get(nums.get(i)) > leftCount) {
                    leftCount = leftMap.get(nums.get(i));
                    leftDom = nums.get(i);
                }
            }
            decMap(nums.get(i), rightMap);
            if (leftCount > (i+1) / 2 && rightMap.containsKey(leftDom) && rightMap.get(leftDom) > (nums.size()-(i+1))/2) {
                return i;
            }
        }
        return -1;
        
        
    }
}
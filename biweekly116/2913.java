class Solution {
    public int sumCounts(List<Integer> nums) {
        int ret = 0;
        
        
        for (int i = 0; i < nums.size(); i++) {
            Set<Integer> mySet = new HashSet<>();
            mySet.add(nums.get(i));
            int running = mySet.size() * mySet.size();
            
            ret += running;
            for (int j = i+1; j < nums.size(); j++) {
                mySet.add(nums.get(j));
                running = mySet.size() * mySet.size();
                ret += running;
            }
        }
        
        return ret;
    }
}
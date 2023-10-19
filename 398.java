class Solution {
    Map<Integer, List<Integer>> numToIndexListMap;

    public Solution(int[] nums) {
        numToIndexListMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            List<Integer> myList = numToIndexListMap.getOrDefault(nums[i], new ArrayList<>());
            myList.add(i);
            numToIndexListMap.put(nums[i], myList);
        }
    }
    
    public int pick(int target) {
        List<Integer> myList = numToIndexListMap.get(target);
        int size = myList.size();
        Random rand = new Random();
        
        return myList.get(rand.nextInt(size));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
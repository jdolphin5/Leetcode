class Solution {
    public int minimumSum(int[] nums) {
        int ret = Integer.MAX_VALUE;
        
        TreeMap<Integer, Integer> beforeMap = new TreeMap<>();
        TreeMap<Integer, Integer> afterMap = new TreeMap<>();
        
        for (int i = 1; i < nums.length; i++) {
            afterMap.put(nums[i], afterMap.getOrDefault(nums[i], 0) + 1);
        }
        
        for (int i = 1; i < nums.length-1; i++) {
            beforeMap.put(nums[i-1], beforeMap.getOrDefault(nums[i-1], 0) + 1);
            afterMap.put(nums[i], afterMap.get(nums[i]) - 1);
            if (afterMap.get(nums[i]) == 0) {
                afterMap.remove(nums[i]);
            }
            
            Integer beforeVal = beforeMap.firstKey();
            Integer afterVal = afterMap.firstKey();
            
            if (beforeVal < nums[i] && afterVal < nums[i]) {
                ret = Math.min(ret, beforeVal + nums[i] + afterVal);
                //System.out.println("before: " + beforeVal + " nums[i] : " + nums[i] + " after: " + afterVal);
            }
        }
        
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        int ret = Integer.MAX_VALUE;
        Map<Integer, Integer> myMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == x) {
                ret = i+1;
            }
            myMap.put(sum, i);
        }

        sum = 0;
        
        for (int i = nums.length-1; i >= 0; i--) {
            sum += nums[i];

            if (sum == x) {
                ret = Math.min(ret, (nums.length-i));
            }

            if (myMap.containsKey(x-sum) && myMap.get(x-sum) < i) {
                ret = Math.min(ret, (myMap.get(x-sum)+1) + (nums.length-i));
            }            
        }

        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}
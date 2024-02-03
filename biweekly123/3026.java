class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ret = Long.MIN_VALUE;
        
        long[] prefixSum = new long[nums.length+1];
        
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = sum;
            sum += nums[i];
        }
        prefixSum[nums.length] = sum;
        
        Map<Integer, Long> numberToIndexMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (numberToIndexMap.containsKey(nums[i] + k)) {
                Long val = numberToIndexMap.get(nums[i] + k);
                ret = Math.max(ret, prefixSum[i+1] - val);
            }
            if (numberToIndexMap.containsKey(nums[i] - k)) {
                Long val = numberToIndexMap.get(nums[i] - k);
                ret = Math.max(ret, prefixSum[i+1] - val);
            }
            Long val = numberToIndexMap.getOrDefault(nums[i], Long.MAX_VALUE);
            numberToIndexMap.put(nums[i], Math.min(val, prefixSum[i]));
        }
        
        return ret == Long.MIN_VALUE ? 0 : ret;
    }
}
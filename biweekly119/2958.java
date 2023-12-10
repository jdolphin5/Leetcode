class Solution {
    private boolean good(Map<Integer, Integer> freqMap, int lastAdded, int k) {
        if (lastAdded == -1) {
            return true;
        }
        
        if (freqMap.getOrDefault(lastAdded, 0) <= k-1) return true;
        
        return false;
    }
    
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0;
        int j = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int ret = 0;
        int lastAdded = -1;
        
        while (j < nums.length) {
            if (good(freqMap, nums[j], k)) {
                ret = Math.max(ret, j - i + 1);
                //expand
                freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);
                lastAdded = nums[j];
                //System.out.println("lastAdded: " + lastAdded + "i: " + i + " j: " + j + " ret: " + ret);
                j++;
            }
            else {
                //shrink
                freqMap.put(nums[i], freqMap.get(nums[i]) - 1);
                i++;
            }
        }
        
        return ret;
    }
}
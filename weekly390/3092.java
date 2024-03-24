class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        long[] ret = new long[nums.length];
        
        Map<Integer, Long> numsCountMap = new HashMap<>();
        TreeMap<Long, Long> freqMap = new TreeMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            long oldFreq = numsCountMap.getOrDefault(nums[i], -1L);
            long newFreq = numsCountMap.getOrDefault(nums[i], 0L) + freq[i];
            numsCountMap.put(nums[i], numsCountMap.getOrDefault(nums[i], 0L) + freq[i]);
            if (oldFreq != -1L) {
                freqMap.put(oldFreq, freqMap.get(oldFreq)-1);
                if (freqMap.get(oldFreq) == 0L) {
                    freqMap.remove(oldFreq);
                }
            }
            
            freqMap.put(newFreq, freqMap.getOrDefault(newFreq, 0L) + 1);
            
            ret[i] = freqMap.lastKey();
        }
        
        return ret;
    }
}
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        Map<Integer, Integer> countFreqMap = new HashMap<>();

        int i = 0;
        int j = 0;
        long sum = 0;
        long ret = 0;

        while (j < nums.length) {
            if (j - i == k) {
                sum -= nums[i];
                int ct = numToCountMap.get(nums[i]);
                numToCountMap.put(nums[i], ct-1);
                countFreqMap.put(ct, countFreqMap.get(ct)-1);
                countFreqMap.put(ct-1, countFreqMap.getOrDefault(ct-1, 0) + 1);
                i++;
            }

            sum += nums[j];
            int ct = numToCountMap.getOrDefault(nums[j], 0);
            if (ct > 0) {
                countFreqMap.put(ct, countFreqMap.get(ct)-1);
            }
            numToCountMap.put(nums[j], ct + 1);
            countFreqMap.put(ct+1, countFreqMap.getOrDefault(ct+1, 0) + 1);
            j++;

            //System.out.println("i: " + i + " j: " + j + "ct(1): " + countFreqMap.getOrDefault(1, 0));
            //System.out.println(countFreqMap.toString());

            if (countFreqMap.getOrDefault(1, 0) == k)
                ret = Math.max(ret, sum);
        }

        return ret;

    }
}
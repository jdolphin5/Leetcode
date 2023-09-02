class Solution {
    private void removeOne(List<Integer> nums, int i, Map<Integer, Integer> distinctMap) {
        if (distinctMap.get(nums.get(i)) == 1) {
            distinctMap.remove(nums.get(i));
        }
        else {
            distinctMap.put(nums.get(i), distinctMap.get(nums.get(i))-1);
        }
    }
    
    private void addOne(List<Integer> nums, int i, Map<Integer, Integer> distinctMap) {
        distinctMap.put(nums.get(i), distinctMap.getOrDefault(nums.get(i), 0) + 1);
    }
    
    public long maxSum(List<Integer> nums, int m, int k) {
        int i = 0;
        int j = k;
        long sum = 0;
        long maxSum = 0;
        Map<Integer, Integer> distinctMap = new HashMap<>();
        
        for (int x = 0; x < k; x++) {
            distinctMap.put(nums.get(x), distinctMap.getOrDefault(nums.get(x), 0) + 1);
            sum += nums.get(x);
        }
        
        if (distinctMap.size() >= m) {
            maxSum = Math.max(maxSum, sum);
        }
        
        while (j < nums.size()) {
            removeOne(nums, i, distinctMap);
            sum -= nums.get(i);
            i++;
            sum += nums.get(j);
            addOne(nums, j, distinctMap);
            j++;
            if (distinctMap.size() >= m) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        return maxSum;
        
    }
}
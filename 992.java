class Solution {
    private int subarraysWithLessThanValue(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int ret = 0;
        Map<Integer, Integer> myMap = new HashMap<>();

        while (j <= nums.length) {
            int ct = myMap.size();

            if (ct <= k) {
                ret += j - i;
                if (j < nums.length)
                myMap.put(nums[j], myMap.getOrDefault(nums[j], 0) + 1);
                j++;
            }
            else {
                myMap.put(nums[i], myMap.get(nums[i]) - 1);
                if (myMap.get(nums[i]) == 0)
                    myMap.remove(nums[i]);
                i++;
            }
        
        }

        return ret;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        int a = subarraysWithLessThanValue(nums, k-1);
        int b = subarraysWithLessThanValue(nums, k); 

        return b - a;
    }
}
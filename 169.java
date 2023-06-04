class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<>();
        int max = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int val = myMap.getOrDefault(nums[i], 0) + 1;
            myMap.put(nums[i], val);
            if (max < val) {
                res = nums[i];
                max = val;
            }
        }

        return res;
    }
}
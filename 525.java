class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> myMap = new HashMap<>();

        int sum = 0;
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) {
                ret = i + 1;
            }
            else if (myMap.containsKey(sum)) {
                ret = Math.max(ret, i - myMap.get(sum));
            }
            else {
                myMap.put(sum, i);
            }
        }

        return ret;
    }
}
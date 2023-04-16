class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, 0);

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        int complement = 0;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (hm.containsKey(complement)) {
                result[0] = i;
                result[1] = hm.get(complement);
                return result;
            }
            hm.put(nums[i], i);
        }
        return result;
    }
}
class Solution {
    public int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> myTreeMap = new TreeMap<>();
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            int val = myTreeMap.getOrDefault(nums[i], 0) + 1;
            myTreeMap.put(nums[i], val);
        }

        Integer val = myTreeMap.lastKey();
        int count = 0;

        while (true) {
            Integer nextVal = myTreeMap.lowerKey(val);
            if (nextVal == null) break;

            ret += myTreeMap.get(val) + count;
            count += myTreeMap.get(val);

            val = nextVal;
        }

        return ret;
    }
}
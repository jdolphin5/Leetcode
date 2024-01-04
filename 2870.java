class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int num : nums) {
            myMap.put(num, myMap.getOrDefault(num, 0) + 1);
        }

        int ret = 0;

        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value == 1) return -1;

            int operations = (int)Math.ceil((double)value / 3);
            ret += operations;
        }

        return ret;
    }
}
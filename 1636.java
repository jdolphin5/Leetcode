class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<>();
        List<Integer> myList = new ArrayList<>();
        int[] result = new int[nums.length];
        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            myMap.put(nums[i], myMap.getOrDefault(nums[i], 0) + 1);
        }
        for (int x = 1; x < 101; x++) {
            for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                if (value == x) {
                    for (int b = 0; b < x; b++) {
                        myList.add(key);
                    }
                }
            }
            Collections.sort(myList, Collections.reverseOrder());
            for (int c = 0; c < myList.size(); c++) {
                result[p] = myList.get(c);
                p++;
            }
            myList.clear();
        }

        return result;
        

    }
}

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, Integer> myMap = new HashMap<>();
        boolean hasElementsLeft = true;

        for (int num : nums) {
            myMap.put(num, myMap.getOrDefault(num, 0) + 1);
        }

        while (hasElementsLeft) {
            hasElementsLeft = false;
            List<Integer> myList = new ArrayList<>();

            for (int key : myMap.keySet()) {
                if (myMap.get(key) >= 1) {
                    if (myMap.get(key) >= 2) {
                        hasElementsLeft = true;
                    }
                    
                    myList.add(key);
                    myMap.put(key, myMap.get(key) - 1);
                }
            }

            ret.add(myList);
        }

        return ret;
    }
}
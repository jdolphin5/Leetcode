class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> myMap = new HashMap<>();
        int size = 0;
        int maxListIndex = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                List<Integer> myList = myMap.getOrDefault(j+i, new ArrayList<>());
                myList.add(0, nums.get(i).get(j));
                myMap.put(j+i, myList);
                maxListIndex = Math.max(maxListIndex, j+i);
                size++;
            }
        }

        int[] ret = new int[size];
        int x = 0;

        for (int i = 0; i <= maxListIndex; i++) { 
            List<Integer> retList = myMap.getOrDefault(i, new ArrayList<>());

            for (int num : retList) {
                ret[x++] = num;
            }
        }

        return ret;
    }
}
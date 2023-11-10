class Solution {
    int[] ret = new int[0];

    private void populateArray(Map<Integer, List<Integer>> myMap, int element, int curLen, int len, int[] arr) {
        if (curLen == len) {
            ret = arr;
            return;
        }

        List<Integer> myList = myMap.get(element);

        if (myList == null) {
            return;
        }

        int size = myList.size();

        for (int i = 0; i < size; i++) {
            int cur = myList.get(i);
            myList.remove(new Integer(cur));
            myMap.put(element, myList);

            List<Integer> myList2 = myMap.get(cur);
            myList2.remove(new Integer(element));
            myMap.put(cur, myList2);

            arr[curLen] = cur;
            populateArray(myMap, cur, curLen+1, len, arr);

            myList.add(0, cur);
            myMap.put(element, myList);

            List<Integer> myList3 = myMap.get(cur);
            myList2.add(0, new Integer(element));
            myMap.put(cur, myList3);
        }
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> myMap = new HashMap<>();

        for (int i = 0; i < adjacentPairs.length; i++) {
            List<Integer> myList = myMap.getOrDefault(adjacentPairs[i][0], new ArrayList<>());
            List<Integer> myList2 = myMap.getOrDefault(adjacentPairs[i][1], new ArrayList<>());
            myList.add(adjacentPairs[i][1]);
            myList2.add(adjacentPairs[i][0]);
            myMap.put(adjacentPairs[i][0], myList);
            myMap.put(adjacentPairs[i][1], myList2);
        }

        int end = 0;
        int len = 2;

        for (Map.Entry<Integer, List<Integer>> entry : myMap.entrySet()) {
            if (entry.getValue().size() % 2 == 1) {
                end = entry.getKey();
            }

            len += entry.getValue().size();
        }

        len /= 2;

        int[] arr = new int[len];
        arr[0] = end;

        populateArray(myMap, end, 1, len, arr);

        return ret;
    }
}
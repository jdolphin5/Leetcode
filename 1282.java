class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> myMap = new HashMap<>();
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            myMap.putIfAbsent(groupSizes[i], new ArrayList<>());
            List<Integer> myList = myMap.get(groupSizes[i]);
            myList.add(i);
            myMap.put(groupSizes[i], myList);
        }

        for (Map.Entry<Integer, List<Integer>> entry : myMap.entrySet()) {
            int gSize = entry.getKey();
            List<Integer> indices = entry.getValue();
            List<Integer> toAdd = new ArrayList<>();

            for (int j = 0; j < indices.size(); j++) {
            toAdd.add(indices.get(j));

                if (toAdd.size() == gSize) {
                    ret.add(toAdd);
                    toAdd = new ArrayList<>();
                }
            }
            
            if (toAdd.size() > 0)
                ret.add(toAdd);
        }

        return ret;
    }
}
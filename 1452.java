class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<String, Integer> myMap = new HashMap<>();
        int id = 0;
        Set<Integer>[] mySetArr = new HashSet[favoriteCompanies.size()];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> myList = favoriteCompanies.get(i);
            for (String s : myList) {
                if (!myMap.containsKey(s)) {
                    myMap.put(s, id++);
                }
            }
            Set<Integer> mySet = new HashSet<>();
            for (String s : myList) {
                mySet.add(myMap.get(s));
            }
            mySetArr[i] = mySet;
        }

        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean bool = true;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i != j && mySetArr[j].containsAll(mySetArr[i])) {
                    bool = false;
                    break;
                }
            }
            if (bool) {
                res.add(i);
            }
        }
        return res;

    }
}
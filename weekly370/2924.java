class Solution {
    private int countChildren(Map<Integer, List<Integer>> myMap, int i, Set<Integer> mySet) {
        
        int ret = 0;
        
        List<Integer> myList = myMap.getOrDefault(i, new ArrayList<>());
        
        for (int j = 0; j < myList.size(); j++) {
            if (!mySet.contains(myList.get(j))) {
                ret++;
                mySet.add(myList.get(j));
                ret += countChildren(myMap, myList.get(j), mySet);
            }
        }
        
        return ret;
    }
    
    public int findChampion(int n, int[][] edges) {
        Map<Integer, List<Integer>> myMap = new HashMap<>();
        
        int ret = -1;
        
        for (int i = 0; i < edges.length; i++) {
            List<Integer> myList = myMap.getOrDefault(edges[i][0], new ArrayList<>());
            myList.add(edges[i][1]);
            myMap.put(edges[i][0], myList);
        }
        
        for (int i = 0; i < n; i++) {
            int childCount = countChildren(myMap, i, new HashSet<>());
            if (childCount == n-1) {
                if (ret != -1) {
                    return -1;
                }
                else {
                    ret = i;
                }
            }
            //System.out.println("i: " + i + " childCount: " + childCount);
        }
        
        return ret;
    }
}
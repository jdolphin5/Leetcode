class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> accessTimeMap = new HashMap<>();
        List<String> ret = new ArrayList<>();
        
        for (int i = 0; i < access_times.size(); i++) {
            List<String> cur = access_times.get(i);
            List<Integer> myList = accessTimeMap.getOrDefault(cur.get(0), new ArrayList<>());
            
            myList.add(Integer.parseInt(cur.get(1)));
            
            accessTimeMap.put(cur.get(0), myList);
        }
        
        for (Map.Entry<String, List<Integer>> entry : accessTimeMap.entrySet()) {
            String id = entry.getKey();
            List<Integer> myList = entry.getValue();
            
            Collections.sort(myList);
            
            int i = 0;
            
            while (i < myList.size()-2) {
                if (myList.get(i) > myList.get(i+2)-100) {
                    ret.add(id);
                    break;
                }
                
                i++;
            }
        }
        
        return ret;
        
    }
}
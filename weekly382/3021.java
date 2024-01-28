class Solution {
    public long flowerGame(int n, int m) {
        long ret = 0;
        
        Map<Boolean, Long> myMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                myMap.put(true, myMap.getOrDefault(true, 0L) + 1L);
            }
            else {
                myMap.put(false, myMap.getOrDefault(false, 0L) + 1L);
            }
        }
        
        //System.out.println(myMap.toString());
        
        for (int j = 1; j <= m; j++) {
            if (j % 2 == 0) {
                ret += myMap.getOrDefault(false, 0L);
            }
            else {
                ret += myMap.getOrDefault(true, 0L);
            }
        }
        
        return ret;
    }
}
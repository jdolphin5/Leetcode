class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Map<String, Integer> myMap = new HashMap<>();
        
        for (int num : arr1) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                myMap.put(s.substring(0, i), i);
            }
        }
        
        int ret = 0;
        
        for (int num : arr2) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                if (myMap.containsKey(s.substring(0, i))) {
                    ret = Math.max(ret, i);
                }
            }
        }
                    
        return ret;
    }
}
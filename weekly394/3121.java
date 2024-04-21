class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Integer, Integer> lastLowercaseIndexMap = new HashMap<>();
        Map<Integer, Integer> firstUppercaseIndexMap = new HashMap<>();
        
        //System.out.println('a'-'A');
        
        for (int i = 0; i < word.length(); i++) {            
            char c = word.charAt(i);
            
            if (c-'a' >= 0) {
                lastLowercaseIndexMap.put(c-'A', i);
            }
            else {
                firstUppercaseIndexMap.putIfAbsent(c-'A', i);
            }
        }
        
        //System.out.println(firstUppercaseIndexMap.toString());
        //System.out.println(lastLowercaseIndexMap.toString());
        
        int ret = 0;
           
        for (int i = 0; i < 100-32; i++) {
            if (lastLowercaseIndexMap.get(i+32) != null && firstUppercaseIndexMap.get(i) != null) {
                if (lastLowercaseIndexMap.get(i+32) < firstUppercaseIndexMap.get(i)) {
                    ret++;
                }
            }
        }
        
        return ret;
    }
}
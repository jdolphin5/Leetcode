class Solution {
    public int findPermutationDifference(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), i);
        }
        
        Map<Character, Integer> tMap = new HashMap<>();
        
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), i);
        }
        
        int ret = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            ret += Math.abs(sMap.get(c) - tMap.get(c));
        }
        
        return ret;
    }
}
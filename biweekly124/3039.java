class Solution {
    public String lastNonEmptyString(String s) {
        int[] bucket = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i)-'a']++;
        }
        
        
        Set<Character> mySet = new HashSet<>();
        int most = 0;
        
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > most) {
                most = bucket[i];
                mySet = new HashSet<>();
                mySet.add((char)('a'+i));
            }
            else if (bucket[i] == most) {
                mySet.add((char)('a'+i));
            }
        }
        
        StringBuilder ret = new StringBuilder();
        
        for (int i = s.length()-1; i >= 0; i--) {
            if (mySet.size() == 0) break;
            if (mySet.contains(s.charAt(i))) {
                ret.append(s.charAt(i));
                mySet.remove(s.charAt(i));
            }
        }
        
        return ret.reverse().toString();
    }
}
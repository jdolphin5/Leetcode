class Solution {
    public long countSubstrings(String s, char c) {
        long ret = 0;
        
        long cCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                cCount++;
            }
        }
        
        return (cCount * (cCount+1)) / 2;
    }
}
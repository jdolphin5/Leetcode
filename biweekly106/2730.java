class Solution {
    
    private boolean isSemiRep(String a) {
        boolean found = false;
        for (int i = 0; i < a.length()-2; i++) {
            if (a.charAt(i) == a.charAt(i+1) && a.charAt(i) == a.charAt(i+2)) {
                return false;
            }
        }
        for (int i = 0; i < a.length()-1; i++) {
            if (a.charAt(i) == a.charAt(i+1)) {
                if (found) return false;
                found = true;
                i++;
            }
        }
        return true;
    }
    
    public int longestSemiRepetitiveSubstring(String s) {
        int i = 0;
        int j = 1;
        int res = 0;
        
        while (j <= s.length()) {
            
            if (isSemiRep(s.substring(i, j))) {
                res = Math.max(res, j - i);
                j++;
            }
            else {
                i++;
            }

        }
        return res;
    }
}
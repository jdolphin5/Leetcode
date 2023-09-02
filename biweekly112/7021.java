class Solution {
    public boolean canBeEqual(String s1, String s2) {
        
        int i = 0;
        for (i = 0; i < 4; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            else if (i < 2 && s1.charAt(i) == s2.charAt(i+2))
                continue;
            else if (i >= 2 && s1.charAt(i) == s2.charAt(i-2))
                continue;
            else {
                break;
            }
        }
        if (i == 4) return true;
        
        return false;
    }
}
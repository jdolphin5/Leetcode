class Solution {
    public boolean isSubsequence(String s, String t) {
        
        char cur;
        int j = 0;
        int i = 0;
        while (i < t.length() && j < s.length()) {
            cur = s.charAt(j);
            if (cur == t.charAt(i)) {
                System.out.println(cur);
                j++;
                i++;
            }
            else {
                i++;
            }
            
            
        }
        if (j == s.length()) return true;

        return false;


    }
}
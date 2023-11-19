package weekly372;
class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int maxLen = Math.max(s1.length(), Math.max(s2.length(), s3.length()));
        
        int ct = 0;
        
        if (s1.equals(s2) && s2.equals(s3)) {
            return 0;
        }
        
        for (int i = maxLen-1; i >= 1; i--) {
            if (i < s1.length()) {
                s1 = s1.substring(0, i);
                ct++;
            }
            if (i < s2.length()) {
                s2 = s2.substring(0, i);
                ct++;
            }
            if (i < s3.length()) {
                s3 = s3.substring(0, i);
                ct++;
            }
            if (s1.equals(s2) && s2.equals(s3)) {
                return ct;
            }
        }
        
        return -1;
    }
}
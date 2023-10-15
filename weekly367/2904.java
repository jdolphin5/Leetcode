class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int numOnes = 0;
        int i = 0;
        int j = 0;
        int minRet = Integer.MAX_VALUE;
        String ret = "z";
        
        while (j < s.length()) {
            if (numOnes < k && j < s.length()) {
                if (s.charAt(j) == '1') {
                    numOnes++;
                }
                j++;
            }
            else if (numOnes == k) {
                int len = j - i;
                String t = s.substring(i, j);
                if (minRet > len) {
                    minRet = len;
                    ret = t;
                }
                else if (minRet == len && ret.compareTo(t) > 0) {
                    ret = t;
                }
                
                //shrink window
                if (s.charAt(i) == '1') {
                    numOnes--;
                }
                i++;
            }
        }
        
        while (numOnes == k) {
            int len = j - i;
            String t = s.substring(i, j);
            if (minRet > len) {
                minRet = len;
                ret = t;
            }
            else if (minRet == len && ret.compareTo(t) > 0) {
                ret = t;
            }

            //shrink window
            if (s.charAt(i) == '1') {
                numOnes--;
            }
            i++;
        }
        
        if (numOnes == k) {
            int len = j - i;
            String t = s.substring(i, j);
            if (minRet > len) {
                minRet = len;
                ret = t;
            }
            else if (minRet == len && ret.compareTo(t) > 0) {
                ret = t;
            }
        }
        
        return ret.equals("z") ? "" : ret;
    }
}
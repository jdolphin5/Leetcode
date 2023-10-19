class Solution {
    public int longestContinuousSubstring(String s) {
        //shortest length is always 1
        //because s.length() >= 1
        int ret = 1; 

        char last = '!';
        int curLen = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c-'a' == last-'a'+1) {
                curLen++;
                ret = Math.max(ret, curLen);
            }
            else {
                curLen = 1;
            }

            last = c;
        }

        return ret;
    }
}
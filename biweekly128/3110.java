class Solution {
    public int scoreOfString(String s) {
        int last = (int)s.charAt(0);
        int ret = 0;
        
        for (int i = 1; i < s.length(); i++) {
            ret += Math.abs(last - (int)(s.charAt(i)));
            last = (int)(s.charAt(i));
        }
        
        return ret;
    }
}
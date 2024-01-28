class Solution {
    public int countKeyChanges(String s) {
        int ret = 0;
        char last = Character.toLowerCase(s.charAt(0));
        for (int i = 0; i < s.length()-1; i++) {
            char cur = Character.toLowerCase(s.charAt(i+1));
            if (cur != last) {
                ret++;
            }
            last = cur;
        }
        
        return ret;
    }
}
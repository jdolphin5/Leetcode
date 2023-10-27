class Solution {
    public boolean isValid(String s) {
        int lastLen = 0;
        int len = -1;

        while (len != lastLen) {
            lastLen = s.length();
            s = s.replace("abc","");
            len = s.length();
        }

        return s.equals("");
    }
}
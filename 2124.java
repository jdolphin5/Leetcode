class Solution {
    public boolean checkString(String s) {
        char[] sArr = s.toCharArray();
        boolean firstB = false;
        for (char c : sArr) {
            if (firstB && c == 'a') {
                return false;
            }
            if (c == 'b') {
                firstB = true;
            }
        }
        return true;
    }
}
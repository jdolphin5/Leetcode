class Solution {
    public int countSegments(String s) {
        int count = 0;
        boolean word = true;
        for (int i = 0; i < s.length(); i++) {
            if (word && s.charAt(i) != ' ') {
                word = false;
                count++;
            }
            if (s.charAt(i) == ' ') {
                word = true;
            }
        }
        return count;
    }
}
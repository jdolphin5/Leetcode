class Solution {
    public int countAsterisks(String s) {
        char[] sArr = s.toCharArray();
        int pairCount = 0;
        int res = 0;

        for (char c : sArr) {
            if (c == '|') {
                pairCount++;
            }
            else if (c == '*' && pairCount % 2 == 0) {
                res++;
            }
        }

        return res;
    }
}
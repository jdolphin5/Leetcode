class Solution {
    public int maxOperations(String s) {
        char[] sArr = s.toCharArray();
        int ret = 0;

        for (int i = 1, x = 0; i < s.length(); i++) {
            if (sArr[i-1] == '1') {
                x++;
            }
            if (sArr[i] == '0' && sArr[i-1] == '1')
                ret += x;
        }

        return ret;
    }
}
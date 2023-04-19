class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        String result = "";

        int minStringSize = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            minStringSize = Math.min(strs[i].length(), minStringSize);
        }

        outerloop:
        for (int i = 0; i < minStringSize; i++) {
            char checkChar = strs[0].charAt(i);
            int checkCount = 0;
            for (int j = 0; j < strs.length; j++) {
                if (checkChar == strs[j].charAt(i)) checkCount++;
                else {
                    break outerloop;
                }
                if (checkCount == strs.length) {
                    result += checkChar;
                }
            }
        }
        return result;
    }
}
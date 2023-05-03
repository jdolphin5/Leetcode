class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        char[] firstWordArr = firstWord.toCharArray();
        char[] secondWordArr = secondWord.toCharArray();
        char[] targetWordArr = targetWord.toCharArray();

        int[] result = new int[3];

        String res = "";
        for (char c : firstWordArr) {
            res += c-'a';
            result[0] = Integer.valueOf(res);
        }

        res = "";
        for (char c : secondWordArr) {
            res += c-'a';
            result[1] = Integer.valueOf(res);
        }

        res = "";
        for (char c : targetWordArr) {
            res += c-'a';
            result[2] = Integer.valueOf(res);
        }

        return result[0] + result[1] == result[2];
    }
}
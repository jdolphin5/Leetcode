class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int i = 0;
        int j = 0;
        int countTrue = 0;
        int countFalse = 0;
        int maxLen = 0;
        while (j < answerKey.length()) {
            if (answerKey.charAt(j) == 'T') {
                countTrue++;
            }
            else {
                countFalse++;
            }

            while (countTrue > k && countFalse > k) {
                if (answerKey.charAt(i) == 'T') {
                    countTrue--;
                }
                else {
                    countFalse--;
                }
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}
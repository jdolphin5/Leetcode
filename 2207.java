class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        char a = pattern.charAt(0);
        char b = pattern.charAt(1);
        
        // try a before first char in text and b after last char in text
        String textA = a + text;
        String textB = text + b;

        int aACount = 0;
        int bACount = 0;

        long textACount = 0;
        long textBCount = 0;

        for (int i = 0; i < textA.length(); i++) {
            char c = textA.charAt(i);
            char d = textB.charAt(i);

            if (c == b) {
                textACount += aACount;
            }
            if (c == a) {
                aACount++;
            }

            if (d == b) {
                textBCount += bACount;
            }
            if (d == a) {
                bACount++;
            }
        }

        return Math.max(textACount, textBCount);
    }
}
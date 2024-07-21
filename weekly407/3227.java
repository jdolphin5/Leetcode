class Solution {
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;

        return false;
    }

    public boolean doesAliceWin(String s) {
        int start = 0;

        boolean bob = false;

        while (start < s.length()) {

            //System.out.println("start: " + start + "c: " + s.charAt(start));

            if (!bob) {
                int x = start;
                int vowel = 0;
                int lastOddVowelIndex = -1;

                while (x < s.length()) {
                    if (isVowel(s.charAt(x))) {
                        vowel++;
                    }

                    if (vowel % 2 == 1) {
                        lastOddVowelIndex = x+1;
                    }

                    x++;
                }
                if (lastOddVowelIndex != -1)
                    start = lastOddVowelIndex;
                else
                    return false;
            }
            else {
                int x = start;
                int vowel = 0;
                int lastEvenVowelIndex = -1;

                while (x < s.length()) {
                    if (isVowel(s.charAt(x))) {
                        vowel++;
                    }

                    if (vowel % 2 == 0) {
                        lastEvenVowelIndex = x+1;
                    }

                    x++;
                }

                
                if (lastEvenVowelIndex != -1) {
                    start = lastEvenVowelIndex;
                }
                else {
                    if (s.length() == 1) return false;
                    s = s.substring(start, start+1);
                    start = 0;
                }

            }

            bob = !bob;
        }

        return bob;
    }
}
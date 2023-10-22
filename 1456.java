class Solution {
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }

    public int maxVowels(String s, int k) {
        int i = 0;
        int j = 0;
        int vowelCount = 0;
        int ret = 0;

        while (j < k) {
            char c = s.charAt(j);
            if (isVowel(c))
                vowelCount++;
            j++;
        }

        ret = Math.max(ret, vowelCount);

        while (j < s.length()) {
            char a = s.charAt(i);
            if (isVowel(a))
                vowelCount--;
            char c = s.charAt(j);
            if (isVowel(c))
                vowelCount++;
            
            i++;
            j++;
            ret = Math.max(ret, vowelCount);
        }

        return ret;
    }
}
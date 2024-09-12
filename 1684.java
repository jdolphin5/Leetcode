class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedChars = new boolean[26];
        int ret = 0;

        for (int i = 0; i < allowed.length(); i++) {
            allowedChars[allowed.charAt(i)-'a'] = true;
        }

        for (String word : words) {
            boolean good = true;
            
            for (int i = 0; i < word.length(); i++) {
                if (!allowedChars[word.charAt(i)-'a']) {
                    good = false;
                    break;
                }
            }

            if (good)
                ret++;
        }

        return ret;
    }
}
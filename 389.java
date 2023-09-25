class Solution {
    public char findTheDifference(String s, String t) {
        int[] sBucket = new int[26];
        int[] tBucket = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sBucket[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            tBucket[t.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sBucket[i] != tBucket[i]) {
                char c = (char)('a'+i);
                return c;
            }
        }

        return 'a';
    }
}
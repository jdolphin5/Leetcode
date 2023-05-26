class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sBucket = new int[26];
        int[] tBucket = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sBucket[s.charAt(i)-'a']++;
            tBucket[t.charAt(i)-'a']++;
        }
        return Arrays.equals(sBucket, tBucket);
    }
}
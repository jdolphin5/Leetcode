class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        int[] bucket = new int[26];
        int poss = 0;
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (bucket[i] % 2 != 0) {
                poss++;
            }
        }
        return poss <= k;
    }
}
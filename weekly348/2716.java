class Solution {
    public int minimizedStringLength(String s) {
        int[] bucket = new int[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) count++;
        }
        return count;
    }
}
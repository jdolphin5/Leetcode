class Solution {
    public int minSteps(String s, String t) {
        int[] sBucket = new int[26];
        int[] tBucket = new int[26];
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            sBucket[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            tBucket[t.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            count += Math.abs(sBucket[i] - tBucket[i]);
        }

        return count;
    }
}
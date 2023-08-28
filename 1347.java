class Solution {
    public int minSteps(String s, String t) {
        int[] sBucket = new int[26];
        int[] tBucket = new int[26];
        int ret = 0;

        for (char c : s.toCharArray()) {
            sBucket[c-'a']++;
        }

        for (char c : t.toCharArray()) {
            tBucket[c-'a']++;
        }

        for (int i = 0; i < sBucket.length; i++) {
            ret += Math.abs(sBucket[i] - tBucket[i]);
        }

        return ret/2;
    }
}
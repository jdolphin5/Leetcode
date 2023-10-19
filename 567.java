class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Bucket = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1Bucket[c-'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int ret = 0;
            int[] s1BucketCopy = s1Bucket.clone();

            for (int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                if (s1BucketCopy[c-'a'] > 0) {
                    s1BucketCopy[c-'a']--;
                    ret++;
                }
                else {
                    break;
                }

                if (ret == s1.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
class Solution {

    private boolean checkDistinct(int[] word1Bucket, int[] word2Bucket) {
        int count1 = 0;
        int count2 = 0;
        for (int num : word1Bucket) {
            if (num > 0) count1++;
        }
        for (int num : word2Bucket) {
            if (num > 0) count2++;
        }
        return count1 == count2;
    }

    public boolean isItPossible(String word1, String word2) {
        int[] word1Bucket = new int[26];
        int[] word2Bucket = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            word1Bucket[word1.charAt(i)-'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            word2Bucket[word2.charAt(i)-'a']++;
        }


        for (int i = 0; i < word1Bucket.length; i++) {
            for (int j = 0; j < word2Bucket.length; j++) {
                if (word1Bucket[i] > 0 && word2Bucket[j] > 0) {
                    word1Bucket[i]--;
                    word2Bucket[i]++;
                    word2Bucket[j]--;
                    word1Bucket[j]++;
                    if (checkDistinct(word1Bucket, word2Bucket)) return true;
                    word2Bucket[j]++;
                    word1Bucket[j]--;
                    word1Bucket[i]++;
                    word2Bucket[i]--;
                }
            }
        }
            

        return false;

    }
}
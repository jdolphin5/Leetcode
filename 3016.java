class Solution {
    public int minimumPushes(String word) {
        int[] letterCount = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            letterCount[c-'a']++;
        }

        Arrays.sort(letterCount);
        int letterIndex = 0;
        int ret = 0;

        for (int i = letterCount.length-1; i >= 0; i--) {
            if (letterCount[i] == 0)
                break;
            else {
                ret += letterCount[i] * (1 + (letterIndex / 8));
                letterIndex++; 
            }
        }

        return ret;
    }
}
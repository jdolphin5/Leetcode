class Solution {
    private boolean isPrefixAndSuffix(String word1, String word2) {
        if (word1.length() > word2.length()) return false;
        
        //String word1Reversed = new StringBuilder(word1).reverse().toString();
        
        return word2.substring(0, word1.length()).equals(word1) && word2.substring(word2.length()-word1.length(), word2.length()).equals(word1);
    }
    
    public int countPrefixSuffixPairs(String[] words) {
        int ret = 0;
        
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    ret++;
                }
                System.out.println("i: " + i + " J: " + j + " ret: " + ret);
            }
        }
        
        return ret;
    }
}
class Solution {
    private boolean checkWord(String word1, String word2) {
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            char d = word2.charAt(i);
            if (c != '?' && c != d) return false; 
        }
        
        return true;
    }
    
    private int recur(String word, int k, boolean first, String originalWord) {
        if (!first && checkWord(word, originalWord)) {
            return 0;
        }
        
        int ans = Integer.MAX_VALUE;
        
            int cur = 1 + recur(word.substring(k, word.length()) + "?".repeat(k), k, false, originalWord);
            ans = Math.min(ans, cur);
        
        return ans;
    }
    
    public int minimumTimeToInitialState(String word, int k) {
        return recur(word, k, true, word);
    }
}
class Solution {
    private boolean isPal(String word) {
        for (int i = 0; i < word.length()/2; i++) {
            if (word.charAt(i) != word.charAt(word.length()-1-i))
                return false;
        }

        return true;
    }

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPal(word)) {
                return word;
            }
        }

        return "";
    }
}
class Solution {
    public String reversePrefix(String word, char ch) {
        int i = 0;
        
        while (i < word.length() && word.charAt(i) != ch)
            i++;

        if (i == word.length())
            return word;

        StringBuilder sb = new StringBuilder(word.substring(0, i+1));

        return sb.reverse().toString() + word.substring(i+1, word.length());
    }
}
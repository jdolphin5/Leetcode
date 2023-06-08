class Solution {
    public boolean isCircularSentence(String sentence) {
        for (int i = 1; i < sentence.length()-1; i++) {
            if (sentence.charAt(i) == ' ') {
                char c = sentence.charAt(i-1);
                char c2 = sentence.charAt(i+1);
                if (c != c2) return false;
            }
        }
        if (sentence.charAt(sentence.length()-1) == sentence.charAt(0)) return true;

        return false;

    }
}
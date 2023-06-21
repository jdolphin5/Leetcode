class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 1; i < words.length; i++) {
            int j = 0;
            while (j < words[i-1].length() || j < words[i].length()) {
                int a;
                int b;
                if (j < words[i-1].length()) {
                    a = 1+order.indexOf(words[i-1].charAt(j));
                }
                else {
                    a = 0;
                }
                if (j < words[i].length()) {
                    b = 1+order.indexOf(words[i].charAt(j));
                }
                else {
                    b = 0;
                }
                    
                if (b > a) {
                    // good
                    break;
                }
                else if (b == a) {
                    // continue
                    j++;
                } 
                else { 
                    return false;
                }
            }
        }
        return true;
    }
}
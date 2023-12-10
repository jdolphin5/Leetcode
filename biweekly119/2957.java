class Solution {
    public int removeAlmostEqualCharacters(String word) {        
        char last = ' ';
        int ret = 0;
        
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == last || word.charAt(i) == last-1 || word.charAt(i) == last+1) {
                last = 'A';
                ret++;
            }
            else {
                last = word.charAt(i);
            }
        }
        
        return ret;
    }
}
class Solution {
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
    
    public int beautifulSubstrings(String s, int k) {
        int ret = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int vowelCount = 0;
            int consonantCount = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (isVowel(c)) vowelCount++;
                else consonantCount++;
                
                if (vowelCount == consonantCount) {
                    if (vowelCount * consonantCount % k == 0) {
                        ret++;
                    }
                }
            }
        }
        
        return ret;
    }
}
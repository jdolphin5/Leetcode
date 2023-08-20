class Solution {
    public boolean isAcronym(List<String> words, String s) {
        String res = "";
        for (int i = 0; i < words.size(); i++) {
            res += words.get(i).charAt(0);
        }
        
        return s.equals(res);
    }
}
class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> hash = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (hash.containsKey(sChar)) { 
                if (!hash.get(sChar).equals(tChar)) return false;
            }
            else {
                if (!hash.containsValue(tChar)) {
                    hash.put(sChar, tChar);
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
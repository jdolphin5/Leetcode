class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sRet = new StringBuilder();
        StringBuilder tRet = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#') {
                sRet.append(c);
            }
            else if (sRet.length() > 0) {
                sRet.deleteCharAt(sRet.length()-1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c != '#') {
                tRet.append(c);
            }
            else if (tRet.length() > 0) {
                tRet.deleteCharAt(tRet.length()-1);
            }
        }

        return sRet.toString().equals(tRet.toString());
    }
}
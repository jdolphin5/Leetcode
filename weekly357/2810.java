class Solution {
    public String finalString(String s) {
        String a = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                String nstr = "";
                for (int j=0; j<a.length(); j++) {
                    char ch = a.charAt(j);
                    nstr = ch + nstr;
                }
                a = nstr;
            }
            else {
                a += s.charAt(i);
            }
        }
        return a;
    }
}
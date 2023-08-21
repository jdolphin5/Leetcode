class Solution {
    public boolean repeatedSubstringPattern(String s) {

        for (int i = 1; i <= s.length()/2; i++) {
            if (s.length() % i == 0) {
                String sub = s.substring(0, i);
                String a = new String(s);
                //System.out.println(sub);
                a = a.replace(sub, "");
                //System.out.println(a);
                if (a.equals("")) {
                    return true;
                }
            }
        }

        return false;
    }
}
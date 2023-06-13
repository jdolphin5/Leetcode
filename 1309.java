class Solution {
    public String freqAlphabets(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                String myString = "" + s.charAt(i-2) + s.charAt(i-1);
                res.insert(0, (char)('a'-1+Integer.valueOf(myString)));
                i-=2;
            }
            else {
                res.insert(0, (char)('a'-1+Character.getNumericValue(s.charAt(i))));
            }
        }

        return new String(res);
    }
}
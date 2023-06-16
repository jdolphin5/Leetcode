class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        while (i >= 0 || j >= 0 || carry > 0)
        {
            char c;
            char d;
            if (i < 0) c = '0';
            else c = a.charAt(i);
            if (j < 0) d = '0';
            else d = b.charAt(j);
            int sum = carry + Character.getNumericValue(c) + Character.getNumericValue(d);
            carry = 0;
            if (sum == 1) {
                res.insert(0, "1");
            }
            else if (sum == 2) {
                carry = 1;
                res.insert(0, "0");
            }
            else if (sum == 3) {
                carry = 1;
                res.insert(0, "1");
            }
            else {
                res.insert(0, "0");
            }

            i--;
            j--;
        }
        return new String(res);
    }
}
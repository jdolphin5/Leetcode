class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuilder s = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            char a, b;
            if (i >= 0) a = num1.charAt(i);
            else a = '0';
            if (j >= 0) b = num2.charAt(j);
            else b = '0';
            int sum = Character.getNumericValue(a) + Character.getNumericValue(b);
            s.insert(0, (carry + sum) % 10);
            carry = (carry + sum) / 10;
            i--;
            j--;
        }

        return new String(s);
    }
}
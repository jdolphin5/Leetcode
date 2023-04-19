class Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int carry = 0;
        String product = "";
        for (int i = 0; i <= m + n || carry != 0; ++i) {
            for (int j = Math.max(0, i - n); j <= Math.min(i, m); ++j) {
                carry += (num1.charAt(m - j) - '0') * (num2.charAt(n - i + j) - '0');
            }
            product += (char)(carry % 10 + '0');
            carry /= 10;
        }
        product = new StringBuilder(product).reverse().toString();
        return product;
    }
}
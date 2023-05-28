class Solution {
    public String removeTrailingZeros(String num) {
        String res = new String(num);
        for (int i = num.length()-1; i >= 0; i--) {
            if (num.charAt(i) == '0') {
                res = res.substring(0, i);
            }
            else {
                break;
            }
        }
        return res;
    }
}
class Solution {
    private StringBuilder helper(StringBuilder a, StringBuilder b, int x, int n, int lastDigit, int i, int l) {
        if (x == n) {
            return a;
        }

        //check if curDigit == lastDigit
        //if it does, l++
        if (i < a.length() && a.charAt(i)-'0' == lastDigit) {
            l++;
        }
        //if it doesn't
        //add l and add last Digit, set l (count of lastDigit to 1)
        else {
            if (l > 0) {
                b.append(String.valueOf(l));
                b.append(String.valueOf(lastDigit));
            }
            l = 1;
        }
        if (i == a.length()) {
            return helper(b, new StringBuilder(), x+1, n, b.charAt(0)-'0', 1, 1);
        }
        return helper(a, b, x, n, a.charAt(i)-'0', i+1, l);
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        return new String(helper(new StringBuilder("1"), new StringBuilder(), 1, n, 1, 1, 1));
    }
}
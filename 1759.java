class Solution {
    public int countHomogenous(String s) {
        char last = '^';
        int len = 1;
        int ret = 0;
        final int MOD = 1000000007;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == last) {
                len++;
            }
            else {
                len = 1;
                last = c;
            }

            ret = (ret + len) % MOD;
        }

        return ret;
    }
}
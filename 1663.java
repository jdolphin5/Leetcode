class Solution {
    public String getSmallestString(int n, int k) {
        char[] ret = new char[n];

        for (int i = n-1; i >= 0; i--) {
            int j = Math.min(26, k - i);
            k -= j;
            ret[i] = (char)('a' + (j-1));
        }

        return new String(ret);
    }
}
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n < 0) {
            return false;
        }

        long val = 1;
        int i = 0;

        while (val <= n) {
            if (val == n) {
                return true;
            }
            i++;
            val = (long)Math.pow(4, i);
        }

        return false;
    }
}
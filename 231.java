class Solution {
    public boolean isPowerOfTwo(int n) {
        int num = 1;
        int i = 0;

        while (i++ < 31) {
            if (num == n) return true;
            num *= 2;
        }

        return false;
    }
}
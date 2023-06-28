class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1000000007;
        long ret = 0;
        int binaryDigits = 0; //number of binary digits in cur number
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                binaryDigits++;
            }
            ret = ((ret << binaryDigits) + i) % MOD; //bitshift the last result by number of binary digits in cur number, then append cur number to end (i)
        }
        return (int)ret;
    }
}
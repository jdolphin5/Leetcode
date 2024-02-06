class Solution {
    public int minOperations(int n) {
        int ret = 0;

        for (int i = 0; i < n; i++) {
            ret += Math.abs(n - ((2 * i) + 1));
        }

        return ret/2;
    }
}
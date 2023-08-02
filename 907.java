class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1000000007;
        long sum = 0;
        int j = 0;
        int i = 0;

        while (i < arr.length) {
            int min = Integer.MAX_VALUE;
            while (j < arr.length) {
                if (arr[j] < min) {
                    min = arr[j];
                }
                sum += min;
                j++;
            }
            i++;
            j = i;
        }

        return (int)((sum + MOD) % MOD);
    }
}
class Solution {
    public int valueAfterKSeconds(int n, int k) {
        final int MOD = 1000000007;
        
        int[] sum = new int[n];
        Arrays.fill(sum, 1);
        
        while (k-- > 0) {
            for (int i = 1; i < n; i++) {
                sum[i] = (sum[i] + sum[i-1]) % MOD;
            }
        }
        
        //k = 1 => a[0] = a[0], a[1] = a[0] + a[1],         a[2] = a[0] + a[1] + a[2]
        //k = 2 => a[0] = a[0], a[1] = a[0] + a[0] + a[1],  a[2] = a[0] + a[0] + a[1] + a[0] + a[1] + a[2]
        //a[0] = a[0], a[1] = a[0] + a[0] + a[0] + a[1]
        
        return sum[n-1];
        
    }
}
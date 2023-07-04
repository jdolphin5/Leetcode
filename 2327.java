class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1000000007;
        long know[] = new long[n];
        long forgot[] = new long[n];
        long total[] = new long[n];
        for (int i = 0; i < n; i++) {
            if (i < delay) {
                know[i] = 1;
            }
            else {
                if (i >= forget) {
                    forgot[i] += know[i-forget] % MOD;
                    forgot[i] %= MOD;
                    //System.out.println("i: " + i + " forgot: " + Arrays.toString(know));
                }
                know[i] += know[i-1] % MOD;
                know[i] += ((know[i-delay] % MOD) - (forgot[i] % MOD) + MOD) % MOD;
                know[i] %= MOD;

                //System.out.println("know: " + Arrays.toString(know));
                //System.out.println("cur: " + (know[i]+forgot[i]));
            }
            total[i] = (know[i] - forgot[i] + MOD) % MOD;
            total[i] %= MOD;
        }
        return (int)(total[n-1] % MOD);
    }
}
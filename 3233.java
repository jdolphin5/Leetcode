class Solution {
    private static boolean[] sieve(int n){
            n = (int)Math.sqrt(n);
            int ret = 0;
            boolean[] prime = new boolean[n + 1];
    
            for (int i = 2; i <= n; i++) prime[i] = true;
    
            for (int p = 2; p <= n; p++) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
    
            return prime;
        }
    
        public int nonSpecialCount(int l, int r) {
            boolean[] prime = sieve(r);
            int ret = 0;
    
            for (int i = 2; i <= (int)Math.sqrt(r); i++) {
                if (prime[i]) {
                    int sq = i * i;
                    if (sq <= r && sq >= l) {
                        ret++;
                    }
                }
            }
    
            return r - l + 1 - ret;
        }
    }
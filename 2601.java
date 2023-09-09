class Solution {
    private static boolean[] sieve(int n) {  
        boolean prime[] = new boolean[n + 1];
        for (int i = 2; i <= n; i++) prime[i] = true;
        for (int p = 2; p*p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        return prime;
    }

    public boolean primeSubOperation(int[] nums) {
        boolean[] primes = sieve(1001);
        int last = 0;

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            boolean primeSubtracted = false;
            
            if (cur <= last) {
                return false;
            }

            //biggest number of p less than nums[i] while nums[i] remains greater than the last number (nums[i-1])
            for (int j = cur-1; j > 0; j--) {
                if (primes[j] && nums[i] - j > last) {
                    last = nums[i]-j;
                    primeSubtracted = true;
                    break;
                }
            }

            if (!primeSubtracted)
                last = nums[i];
        }

        return true;
    }
}
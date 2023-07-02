class Solution {
    private static boolean[] sieve(int n){
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

    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieve(right);
        List<Integer> primeList = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];
        
        Arrays.fill(result, -1);

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) primeList.add(i);
        }

        if (primeList.size() < 2) return result;

        for (int i = 0; i < primeList.size(); i++) {
            for (int j = i+1; j < primeList.size(); j++) {
                int x = primeList.get(i);
                int y = primeList.get(j);
                int diff = y - x;
                if (diff < minDiff) {
                    result[0] = x;
                    result[1] = y;
                    minDiff = diff;
                    if (minDiff <= 2) return result;
                }
            }
        }

        return result;

    }
}
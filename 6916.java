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
    
    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] isPrime = sieve(n);
        Set<Integer> primeSet = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            if (isPrime[i]) primeSet.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 2; i <= n/2; i++) {
            
            if (primeSet.contains(i) && primeSet.contains(n-i)) {
                List<Integer> myList = new ArrayList<>();
                myList.add(i);
                myList.add(n-i);
                res.add(myList);
            }
        }
        
        return res;
        
    }
}
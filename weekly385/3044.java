class Solution {
    private boolean[] sieve(int n) {
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
    
    private List<Integer> computeNumbers(int[][] mat, int i, int j, int dir, int num) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
            return new ArrayList<>();
        }
        
        List<Integer> retList = new ArrayList<>();
        int newNum = (num*10) + mat[i][j];
        retList.add(newNum);
        
        switch(dir) {
            case 0:
                retList.addAll(computeNumbers(mat, i-1, j-1, dir, newNum));
                break;
            case 1:
                retList.addAll(computeNumbers(mat, i-1, j, dir, newNum));
                break;
            case 2:
                retList.addAll(computeNumbers(mat, i-1, j+1, dir, newNum));
                break;
            case 3:
                retList.addAll(computeNumbers(mat, i, j-1, dir, newNum));
                break;
            case 4:
                retList.addAll(computeNumbers(mat, i, j+1, dir, newNum));
                break;
            case 5:
                retList.addAll(computeNumbers(mat, i+1, j-1, dir, newNum));
                break;
            case 6:
                retList.addAll(computeNumbers(mat, i+1, j, dir, newNum));
                break;
            case 7:
                retList.addAll(computeNumbers(mat, i+1, j+1, dir, newNum));
                break;
            
            default:
                
        }
        
        return retList;
    }
    
    public int mostFrequentPrime(int[][] mat) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        int maxNum = 0;
        
        List<Integer> nums = new ArrayList<>();
        
        for (int x = 0; x < mat.length; x++) {
            for (int y = 0; y < mat[0].length; y++) {
                for (int i = 0; i <= 7; i++) {
                    nums.addAll(computeNumbers(mat, x, y, i, 0));
                }
            }
        }
        
        //System.out.println(nums.toString());
        
        for (int num : nums) {
            if (num > 10)
                numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
            maxNum = Math.max(num, maxNum);
        }
        
        boolean[] primes = sieve(maxNum);
        
        int maxFreq = 0;
        int ret = -1;
        
        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            
            if (!primes[num]) continue;
            
            if (freq > maxFreq || (freq == maxFreq && num > ret)) {
                ret = num;
                maxFreq = freq;
            }
        }
        
        return ret;
    }
}
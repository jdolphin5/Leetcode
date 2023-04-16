class Solution {
    
    private boolean isDivisible(int num, int divisor) {
        if (num % divisor == 0) return true;
        return false;
    }
    
    public int maxDivScore(int[] nums, int[] divisors) {
        int[] divisorCountArr = new int[divisors.length];
        int divisorCount = 0;
        
        for (int i = 0; i < divisors.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (isDivisible(nums[j], divisors[i])) {
                    divisorCount++;
                }
            }
            divisorCountArr[i] = divisorCount;
            divisorCount = 0;
        }
        int lastMinMaxDivisor = divisors[0];
        int lastMinMaxDivisorCount = 0;
        
        for (int i = 0; i < divisorCountArr.length; i++) {
            if (divisorCountArr[i] > lastMinMaxDivisorCount) {
                lastMinMaxDivisorCount = divisorCountArr[i];
                lastMinMaxDivisor = divisors[i];
            }
            else if (divisorCountArr[i] == lastMinMaxDivisorCount) {
                if (lastMinMaxDivisor > divisors[i]) {
                    lastMinMaxDivisorCount = divisorCountArr[i];
                    lastMinMaxDivisor = divisors[i];
                }
            }
        }
        
        return lastMinMaxDivisor;
        
        
    }
}
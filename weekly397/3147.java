class Solution {
    
    private int recur(Integer[] dp, int i, int[] energy, int k) {
        if (i >= energy.length) {
            return 0;
        }
        
        if (dp[i] != null) {
            return dp[i];
        }
        
        int ret = 0;
        
        ret = energy[i] + recur(dp, i+k, energy, k);
        
        return dp[i] = ret;
    }
    
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        Integer[] dp = new Integer[energy.length];
        
        for (int i = 0; i < energy.length; i++) {
            max = Math.max(max, recur(dp, i, energy, k));
        }
        
        return max;
    }
}
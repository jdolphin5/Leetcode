class Solution {
    private int recur(Integer[][] dp, int[] prices, int i, int freeCount) {
        if (i == prices.length) {
            return 0;
        }
        
        if (dp[i][freeCount] != null) {
            return dp[i][freeCount];
        }
        
        int take = prices[i] + recur(dp, prices, i+1, i+1);
        int leave = 1000001;
        
        if (freeCount > 0) {
            leave = recur(dp, prices, i+1, freeCount-1);
        }
        
        return dp[i][freeCount] = Math.min(take, leave);
    }
    
    public int minimumCoins(int[] prices) {
        Integer[][] dp = new Integer[prices.length][prices.length+1];
        
        return recur(dp, prices, 0, 0);
    }
}
class Solution {
    private int recur(Integer[][] dp, int[] rewardValues, int i, int runningSum) {
        if (i == rewardValues.length) {
            return runningSum;
        }
        
        if (dp[i][runningSum] != null) {
            return dp[i][runningSum];
        }
        
        int cur = rewardValues[i];
        int take = 0;
        
        if (cur > runningSum) {
            take = recur(dp, rewardValues, i+1, runningSum + cur);
        }
        
        int leave = recur(dp, rewardValues, i+1, runningSum);
        
        return dp[i][runningSum] = Math.max(take, leave);
    }
    
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        
        Integer[][] dp = new Integer[rewardValues.length][4001];
        
        return recur(dp, rewardValues, 0, 0);
    }
}
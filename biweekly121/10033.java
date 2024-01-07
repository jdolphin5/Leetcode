class Solution {
    private int recur(Integer[] dp, int x, int y) {
        if (y > x) return y - x;
        else if (y == x) return 0;
        
        if (dp[x] != null) {
            return dp[x];
        }
        
        int nextMultipleOfEleven = x;
        int nextMultipleOfFive = x;
        int prevMultipleOfEleven = x;
        int prevMultipleOfFive = x;
        
        while (nextMultipleOfEleven % 11 != 0) nextMultipleOfEleven++;
        while (nextMultipleOfFive % 5 != 0) nextMultipleOfFive++;
        while (prevMultipleOfEleven % 11 != 0) prevMultipleOfEleven--;
        while (prevMultipleOfFive % 5 != 0) prevMultipleOfFive--;
        
        int a = nextMultipleOfEleven - x + 1 + recur(dp, nextMultipleOfEleven / 11, y);
        int b = nextMultipleOfFive - x + 1 + recur(dp, nextMultipleOfFive / 5, y);
        int c = x - prevMultipleOfEleven + 1 + recur(dp, prevMultipleOfEleven / 11, y);
        int d = x - prevMultipleOfFive + 1 + recur(dp, prevMultipleOfFive / 5, y);
        int e = x - y;
            
        int ret = Integer.MAX_VALUE;
        
        ret = Math.min(a, Math.min(b, Math.min(c, Math.min(d, e))));
        
        return dp[x] = ret;
    }
    
    public int minimumOperationsToMakeEqual(int x, int y) {
        Integer[] dp = new Integer[10001];
        
        if (y > x) {
            return y - x;
        }
        
        return recur(dp, x, y);
        
    }
}
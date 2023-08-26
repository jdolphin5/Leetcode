class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] prefixCandies = new long[candiesCount.length+1];
        
        long runningSum = 0;

        for (int i = 0; i < candiesCount.length; i++) {
            prefixCandies[i] = runningSum;
            runningSum += candiesCount[i];
        }

        prefixCandies[prefixCandies.length-1] = runningSum;

        boolean[] ret = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int dailyCap = queries[i][2];

            long maxDay = prefixCandies[type+1]-1; 
            long minDay = prefixCandies[type]/dailyCap; 
        
            // check if query day is within the limits (minDay and maxDay inclusive)
            ret[i] = (minDay <= day && day <= maxDay);  
        }

        return ret;
    }
}
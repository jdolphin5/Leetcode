class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int myInt1 = 0;
        int myInt2 = 0;

        for (int i = cost.length-1; i >= 0; i--) {
            int myInt0 = cost[i] + Math.min(myInt1, myInt2);
            myInt2 = myInt1;
            myInt1 = myInt0;
        }

        return Math.min(myInt1, myInt2);

    }
}
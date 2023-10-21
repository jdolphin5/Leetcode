class Solution {
    private int recur(Integer[][] dp, int[] stones, int i, int leftSum, int total) {
        if (i == stones.length) {
            return Math.abs(total - leftSum*2);
        }

        if (dp[i][leftSum] != null) {
            return dp[i][leftSum];
        }

        int take = Integer.MAX_VALUE;
        int leave = Integer.MAX_VALUE;

        take = recur(dp, stones, i+1, leftSum+stones[i], total);
        leave = recur(dp, stones, i+1, leftSum, total);

        return dp[i][leftSum] = Math.min(take, leave);
    }

    public int lastStoneWeightII(int[] stones) {
        Integer[][] dp = new Integer[stones.length][3001];

        int total = 0;

        for (int num : stones) {
            total += num;
        }

        return recur(dp, stones, 0, 0, total);
    }
}
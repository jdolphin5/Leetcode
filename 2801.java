class Solution {

    final int MOD = 1000000007;

    private void resetDp(int[][][][] dp) {
        for (int[][][] arr1 : dp) {
            for (int[][] arr2 : arr1) {
                for (int[] arr3 : arr2) {
                    Arrays.fill(arr3, -1);
                }
            }
        }
    }

    private int digitDp(int[][][][] dp, String a, int index, int eq, int limit, int sum) {
        if (dp[index][eq][limit][sum] != -1) {
            return dp[index][eq][limit][sum];
        }
        if (index == a.length()) {
            if (eq == 1) {
                return 1;
            }
            else {
                return 0;
            }
        }

        int ret = 0;
        for (int i = 0; i < 10; i++) {
            if (sum == 0 && i > a.charAt(index) - '0') {
                continue;
            }
            else if (eq == 1 && Math.abs(limit - i) != 1) {
                continue;
            }
            int limit1 = limit;
            if (i != 0) {
                limit1 = 1;
            }
            int sum1 = sum;
            if (i != a.charAt(index) - '0') {
                sum1 = 1;
            }
            //System.out.println("index+1: " + (index+1) + "limit1: " + limit1 + " i : " + i + " sum1: " + sum1);
            ret += digitDp(dp, a, index+1, limit1, i, sum1);
            ret %= MOD;

        }
        return dp[index][eq][limit][sum] = ret;
        
    }

    public int countSteppingNumbers(String low, String high) {
        int[][][][] dp = new int[101][2][10][2];
        resetDp(dp);
        int ret = digitDp(dp, high, 0, 0, 0, 0);
        resetDp(dp);
        ret -= digitDp(dp, low, 0, 0, 0, 0);
        if (ret < 0) {
            ret += MOD; 
        }
        //add back to account for index = low (included in both digitDp)
        boolean addBack = true;
        for (int i = 0; i+1 < low.length(); i++) {
            if (Math.abs(low.charAt(i) - low.charAt(i+1)) != 1) {
                addBack = false;
            }
        }
        if (addBack) ret++;
        return ret % MOD;
    }
}
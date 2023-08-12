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

    private int digitDp(int[][][][] dp, String a, int index, int limit, int isZero, int lastDigit) {
        if (index == a.length()) {
            if (isZero == 1) return 0;
            return 1;
        }
        if (dp[index][limit][isZero][lastDigit+1] != -1) {
            return dp[index][limit][isZero][lastDigit+1];
        }

        int ret = 0;

        for (int i = 0; i < 10; i++) {
            int nextZero = 0;
            int nextLimit = 0;
            if (isZero == 1 && i == 0) {
                nextZero = 1;
            }
            if (limit == 1 && i == a.charAt(index)-'0') {
                nextLimit = 1;
            }
            if (limit == 1 && i > a.charAt(index)-'0') {
                continue;
            }
            if (isZero == 1 || (Math.abs(lastDigit - i) == 1)) {
                ret = (ret + digitDp(dp, a, index+1, nextLimit, nextZero, i)) % MOD;
            }
        }

        return dp[index][limit][isZero][lastDigit+1] = ret;

        
    }

    public int countSteppingNumbers(String low, String high) {
        int[][][][] dp = new int[high.length()][2][2][11];
        resetDp(dp);
        //call dp function with limit = 1, isZero = 1, prevDigit = -1
        int ret = digitDp(dp, high, 0, 1, 1, -1);
        resetDp(dp);
        ret -= digitDp(dp, low, 0, 1, 1, -1);
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
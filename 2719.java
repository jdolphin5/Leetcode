class Solution {
    final int MOD = 1000000007;

    private void resetArray(long[][][] dp) {
        for (long[][] arr1 : dp) {
            for (long[] arr2 : arr1) {
                Arrays.fill(arr2, -1);
            }
        }
    }

    private long digitDp(long[][][] dp, String num, int min_sum, int max_sum, int index, int sum, int limit) {
        if (index == num.length()) {
            if (sum <= max_sum && sum >= min_sum)
                return 1;
            return 0;
        }

        if (dp[index][sum][limit] != -1) {
            return dp[index][sum][limit];
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
            int nextLimit = 0;
            if (limit == 1 && num.charAt(index)-'0' == i) {
                nextLimit = 1;
            }
            if (limit == 1 && num.charAt(index)-'0' < i) {
                break;
            }
            ans += digitDp(dp, num, min_sum, max_sum, index+1, sum, nextLimit) % MOD;
            sum -= i;
        }

        return dp[index][sum][limit] = ans;

    }

    public int count(String num1, String num2, int min_sum, int max_sum) {
        long[][][] dp = new long[num2.length()][401][2];
        resetArray(dp);
        long ret = (digitDp(dp, num2, min_sum, max_sum, 0, 0, 1)) % MOD;
        resetArray(dp);
        ret = (ret - (digitDp(dp, num1, min_sum, max_sum, 0, 0, 1))) % MOD;
        if (ret < 0) {
            ret += MOD;
        }
        int sum = 0;
        for (int i = 0; i < num1.length(); i++) {
            sum += num1.charAt(i)-'0';
        }
        if (sum <= max_sum && sum >= min_sum) {
            ret++;
        }
        return (int)(ret % MOD);
    }
}
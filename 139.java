class Solution {
    private boolean recur(String s, List<String> wordDict, Boolean[] dp, int i) {
        if (i == dp.length) return true;

        if (dp[i] != null) return dp[i];

        for (int k = i+1; k <= dp.length; k++) {
            if (wordDict.contains(s.substring(i, k)) && recur(s, wordDict, dp, k)) {
                return dp[i] = true;
            }
        }
        return dp[i] = false;

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()]; //Boolean object to contain nulls initially

        return recur(s, wordDict, dp, 0);

    }
}
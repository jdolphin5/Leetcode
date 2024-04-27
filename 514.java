class Solution {
    private int recur(String key, Map<Character, List<Integer>> ringMap, Integer[][] dp, int i, int angle) {
        if (i == key.length()) {
            return 0;
        }

        if (dp[i][angle] != null) {
            return dp[i][angle];
        }

        List<Integer> ringIndexList = ringMap.get(key.charAt(i));
        int ans = Integer.MAX_VALUE;

        for (int x : ringIndexList) {
            ans = Math.min(ans, 1 + Math.min(Math.abs(angle - x), Math.min(Math.abs(dp[0].length + angle - x), Math.abs(dp[0].length - angle + x))) + recur(key, ringMap, dp, i+1, x));
        }

        return dp[i][angle] = ans;
    }

    public int findRotateSteps(String ring, String key) {
        Integer[][] dp = new Integer[key.length()][ring.length()]; //key index, distance to char in ring
        Map<Character, List<Integer>> ringMap = new HashMap<>();

        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            List<Integer> ringIndexList = ringMap.getOrDefault(c, new ArrayList<>());
            ringIndexList.add(i);
            ringMap.put(c, ringIndexList);
        }

        return recur(key, ringMap, dp, 0, 0);
    }
}
class Solution {
    private int recur(Integer[] dp, ArrayList<Integer>[] relListArr, int[] time, int i) {
        if (dp[i] != null) {
            return dp[i];
        }

        int ret = 0;

        for (int j = 0; j < relListArr[i].size(); j++) {
            int val = relListArr[i].get(j);
            ret = Math.max(ret, recur(dp, relListArr, time, val));
        }

        return dp[i] = ret + time[i-1];

    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<Integer>[] relListArr = new ArrayList[n+1];

        for (int i = 0; i < relListArr.length; i++) {
            relListArr[i] = new ArrayList<>();
        }

        for (int[] rel : relations) {
            relListArr[rel[0]].add(rel[1]);
        }

        Integer[] dp = new Integer[n+1];

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, recur(dp, relListArr, time, i));
        }

        return ans;
    }
}
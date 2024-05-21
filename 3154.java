class Solution {  
    private int recur(Map<String, Integer> dp, int k, int i, int x, int canJump) {
        if (i > k+1) {
            return 0;
        }

        String hash = i + "-" + x + "-" + canJump;

        if (dp.containsKey(hash)) {
            return dp.get(hash);
        }

        int up = 0;
        int down = 0;

        if (canJump == 1 && i > 0) {
            down = recur(dp, k, i-1, x, 0);
        }

        up = recur(dp, k, i + (1 << x), x+1, 1);

        int isK = i == k ? 1 : 0;

        dp.put(hash, up + down + isK);

        return up + down + isK;
    }

    public int waysToReachStair(int k) {
        if (k == 0) return 2;
        
        Map<String, Integer> dp = new HashMap<>();

        return recur(dp, k, 1, 0, 1);
    }
}
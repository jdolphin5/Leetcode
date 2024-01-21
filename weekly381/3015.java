class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int k = 1;
        int[] ret = new int[n];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                int useRoadForward = Math.abs(i - x) + 1 + Math.abs(j - y);
                int useRoadBackward = Math.abs(i - y) + 1 + Math.abs(j - x);
                int dontUseRoad = Math.abs(i - j);

                ret[Math.min(useRoadForward, Math.min(useRoadBackward, dontUseRoad))-1]++;
            }
        }
        
        return ret;
    }
}
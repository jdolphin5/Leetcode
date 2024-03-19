class Solution {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> Integer.compare(a[0], b[0]));
        final long MOD = 1000000007;
        int ret = 1;

        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] == -1 && ranges[i][1] == -1)
                continue;

            int next = i+1;

            while (next < ranges.length) {
                if (ranges[i][1] >= ranges[next][0] && ranges[i][0] <= ranges[next][1]) {
                    ranges[i][1] = Math.max(ranges[next][1], ranges[i][1]);
                    ranges[i][0] = Math.min(ranges[next][0], ranges[i][0]);
                    ranges[next][0] = -1;
                    ranges[next][1] = -1;
                    next++;
                }
                else {
                    break;
                }
            }
        }

        int rangesCount = ranges.length;

        for (int[] range : ranges) {
            if (range[0] == -1 && range[1] == -1) {
                rangesCount--;
            }
        }

        for (int i = 0; i < rangesCount; i++) {
            ret *= 2;
            ret %= MOD;
        }

        return ret;
    }
}
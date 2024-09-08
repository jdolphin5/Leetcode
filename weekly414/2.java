class Solution {
    private boolean canMake(int t, int[] start, int d) {
        int last = start[0];

        for (int i = 1; i < start.length; i++) {
            if (last + t <= start[i] + d)
                last = Math.max(last + t, start[i]);
            else
                return false;
        }

        return true;
    }

    public int maxPossibleScore(int[] start, int d) {
        int lower = 0;
        int upper = Integer.MAX_VALUE;

        Arrays.sort(start);

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;

            if (canMake(mid, start, d)) {
                lower = mid+1;
            }
            else {
                upper = mid;
            }
        }

        return canMake(lower, start, d) ? lower : lower-1;
    }
}
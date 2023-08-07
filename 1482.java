class Solution {

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int mCount = 0;
        int adjCount = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                adjCount++;
            }
            else {
                mCount += adjCount/k;
                adjCount = 0;
            }
        }
        mCount += adjCount/k;
        return mCount >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long)m*k) return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            min = Math.min(day, min);
            max = Math.max(day, max);
        }

        int lower = min;
        int upper = max;
        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                upper = mid;
            }
            else {
                lower = mid+1;
            }
        }
        return upper;
    }
}
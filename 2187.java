class Solution {

    private long binarySearch(int[] time, int totalTrips, long lower, long upper) {
        
        long mid = 0;

        while (lower < upper) {
            mid = lower + (upper - lower) / 2;

            long result = 0;

            for (int i = 0; i < time.length; i++) {
                result += (mid / time[i]);
                if (result >= totalTrips) break;
            }
            if (result >= totalTrips) {
                upper = mid;
            }
            else {
                lower = mid + 1;
            }
        }
        return lower;
    }

    public long minimumTime(int[] time, int totalTrips) {
        return binarySearch(time, totalTrips, 1, Long.MAX_VALUE);
    }
}
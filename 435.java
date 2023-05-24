class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int count = 0;
        int i = 0;
        int j = 1;

        while (j < intervals.length) {
            if (intervals[i][1] > intervals[j][1]) {
                i = j;
                count++;
            }
            else if (intervals[i][1] > intervals[j][0]) {
                count++;
            }
            else {
                i = j;
            }
            j++;
        }

        return count;
    }
}
class Solution {
    public class Interval {
        int start;
        int end;
        int i;

        public Interval(int start, int end, int i) {
            this.start = start;
            this.end = end;
            this.i = i;
        }
    }

    public int[] findRightInterval(int[][] intervals) {
        int[] ret = new int[intervals.length];
        Interval[] intervalArr = new Interval[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            intervalArr[i] = new Interval(intervals[i][0], intervals[i][1], i);
        }

        Arrays.sort(intervalArr, (a, b) -> a.start - b.start);

        for (int x = 0; x < intervalArr.length; x++) {
            int next = x;
            while (next < intervals.length) {
                if (intervalArr[x].end <= intervalArr[next].start) {
                    ret[intervalArr[x].i] = intervalArr[next].i;
                    break;
                }
                else {
                    next++;
                }
            }
            if (next == intervals.length) {
                ret[intervalArr[x].i] = -1;
            }
        }

        return ret;
    }
}
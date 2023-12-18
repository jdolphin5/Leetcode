class Solution {
    public class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int findMinArrowShots(int[][] points) {
        List<Interval> curIntervals = new ArrayList<>();
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[0], p2[0]));

        for (int[] point : points) {
            boolean intervalFound = false;

            int x = point[0];
            int x2 = point[1];

            for (Interval interval : curIntervals) {
                if (interval.end >= x) { //interval.start <= x2 && 
                    interval.start = Math.max(interval.start, x);
                    interval.end = Math.min(interval.end, x2);
                    intervalFound = true;
                    break;
                }
            }

            if (!intervalFound) {
                curIntervals.add(new Interval(x, x2));
            }
        }

        return curIntervals.size();
    }
}
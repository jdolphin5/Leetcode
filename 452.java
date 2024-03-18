class Solution {
    public int findMinArrowShots(int[][] points) {
        int ret = 1;

        //need Integer.compare() instead of a[0] - b[0] comparator due to overflow of Integer.MIN_VALUE - Integer.MAX_VALUE
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int min = points[0][0];
        int max = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][1] >= min && points[i][0] <= max) {
                min = Math.max(min, points[i][0]);
                max = Math.min(max, points[i][1]);
            }
            else {
                min = points[i][0];
                max = points[i][1];
                ret++;
            }
        }

        return ret;
    }
}
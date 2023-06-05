class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int seconds = 0;
        for (int i = 0; i < points.length-1; i++) {
            int xDiff = Math.abs(points[i][0] - points[i+1][0]);
            int yDiff = Math.abs(points[i][1] - points[i+1][1]);
            while (xDiff >= 1 && yDiff >= 1) {
                xDiff--;
                yDiff--;
                seconds++;
            }
            seconds += xDiff + yDiff;
        }

        return seconds;
    }
}
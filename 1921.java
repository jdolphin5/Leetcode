class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        //t = d/s
        double[] timeToReachCity = new double[dist.length];

        for (int i = 0; i < dist.length; i++) {
            timeToReachCity[i] = (double)dist[i] / speed[i];
        }

        Arrays.sort(timeToReachCity);

        int i = 1;

        while (i < timeToReachCity.length) {
            if ((double)i >= timeToReachCity[i]) {
                return i;
            }

            i++;
        }

        return i;
    }
}
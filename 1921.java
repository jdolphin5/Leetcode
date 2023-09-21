class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] timeToReachCity = new double[dist.length];

        for (int i = 0; i < dist.length; i++) {
            timeToReachCity[i] = (double)dist[i] / speed[i];
        }

        Arrays.sort(timeToReachCity);

        int ct = 0;

        for (double num : timeToReachCity) {
            if ((int) num < ct) {
                return ct;
            }
            if (num % 1 == 0.0 && (int) num == ct) {
                return ct;
            }
            
            ct++;
        }

        return ct;
    }
}
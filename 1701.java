class Solution {
    public double averageWaitingTime(int[][] customers) {
        double ret = 0;
        int time = 0;

        for (int[] customer : customers) {
            int a = customer[0];
            int b = customer[1];

            if (time <= a) {
                time = a;
            }
            else {
                ret += time - a;
            }

            time += b;
            ret += b;
        }

        return ret / (double)customers.length;
    }
}
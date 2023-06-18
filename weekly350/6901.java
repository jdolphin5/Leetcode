class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int dist = 0;
        while (mainTank >= 5) {
            mainTank -= 5;
            if (additionalTank > 0) {
                mainTank++;
                additionalTank--;
            }
            dist += 50;
        }
        dist += mainTank * 10;
        return dist;
    }
}
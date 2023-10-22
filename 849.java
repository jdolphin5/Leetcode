class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxSpaceBetweenPeople = 1;
        int rollingSpaceBetweenPeople = 0;
        boolean firstPerson = false;
        int edges = 0;

        for (int i = 0; i < seats.length; i++) {
            if (!firstPerson && seats[i] == 0) {
                edges++;
                maxSpaceBetweenPeople = Math.max(maxSpaceBetweenPeople, edges);
            }
            else if (seats[i] == 1) {
                firstPerson = true;
                rollingSpaceBetweenPeople = 1;
            }
            else if (seats[i] == 0) {
                rollingSpaceBetweenPeople++;
            }

            maxSpaceBetweenPeople = Math.max(maxSpaceBetweenPeople, rollingSpaceBetweenPeople/2);
        }

        edges = 0;
        for (int i = seats.length-1; i >= 0; i--) {
            if (seats[i] == 0) {
                edges++;
                maxSpaceBetweenPeople = Math.max(maxSpaceBetweenPeople, edges);
            }
            else {
                break;
            }
        }

        return maxSpaceBetweenPeople;
    }
}
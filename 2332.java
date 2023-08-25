class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int passengersIndex = 0;
        int busesIndex = 0;
        boolean leftOver = false;

        while (busesIndex < buses.length) {
            int busCapacity = capacity;
            leftOver = false;

            while (passengersIndex < passengers.length && 
                    busCapacity > 0 &&
                    passengers[passengersIndex] <= buses[busesIndex]
                    ) {
                passengersIndex++;
                busCapacity--;
            }

            if (busCapacity > 0) leftOver = true;
            busesIndex++;
        }

        int ret = 0;

        if (leftOver) {
            ret = buses[busesIndex-1];
        }
        else if (passengersIndex > 0) {
            ret = passengers[passengersIndex-1]-1;
        }

        Set<Integer> set = new HashSet<>();

        for (int num : passengers) {
            set.add(num);
        }

        while (set.contains(ret)) {
            ret--;
        }

        return ret;
    }
}
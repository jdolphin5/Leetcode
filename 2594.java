class Solution {
    // n cars in (r * n^2) minutes
    // e.g. r = 4 can do 1 car in 4 minutes or 2 cars in 16 minutes
    // ==> in x minutes he can do 2 cars (sqrt(16/4))
    // ==> can do sqrt(minutes/r) cars

    private boolean canRepair(long minutes, int[] ranks, int cars) {
        //sqrt(minutes/r) cars
        //System.out.println(minutes);

        long carsRepaired = 0;

        for (int i = 0; i < ranks.length; i++) {
            carsRepaired += Math.sqrt(minutes/ranks[i]);
        }

        return carsRepaired >= cars;
    }

    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);

        long lower = 0;
        long upper = Long.MAX_VALUE;

        while (lower < upper) {
            long mid = lower + (upper - lower) / 2;
            if (canRepair(mid, ranks, cars)) {
                upper = mid;
            }
            else {
                lower = mid+1;
            }
        }

        return lower;
    }
}
class Solution {
    private boolean canDistributeCandies(int candiesPerChild, int[] candies, long k) {
        long count = 0;

        for (int i = 0; i < candies.length; i++) {
            count += candies[i]/candiesPerChild;
        }

        return count >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);

        int lower = 1;
        int upper = candies[candies.length-1];
        
        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (canDistributeCandies(mid, candies, k)) {
                lower = mid+1;
            }
            else {
                upper = mid;
            }
        }

        if (canDistributeCandies(lower, candies, k)) {
            return lower;
        }

        return lower-1;
    }
}
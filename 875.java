class Solution {

    private boolean checkPossible(int[] piles, int h, int mid) {
        double k = 0;
        for (int i = 0; i < piles.length; i++) {
            k += Math.ceil((double)piles[i]/(double)mid);
            if (k > h) return false;
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int lower = 0;
        int upper = -1;

        for (int num : piles) {
            if (num > upper) upper = num;
        }

        int res = 0;

        int mid;

        while (lower <= upper) {
            mid = lower + (upper - lower) / 2;
            if (!checkPossible(piles, h, mid)) {
                lower = mid+1;
            }
            else {
                upper = mid-1;
                res = mid;
            }
        }

        return res;
    }
}
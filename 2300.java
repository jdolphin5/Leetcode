class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ret = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            //convert long success -> double
            double minPotionValue = (double)success/spells[i];

            int lower = 0;
            int upper = potions.length-1;

            while (lower < upper) {
                int mid = lower + (upper - lower) / 2;
                if ((double)potions[mid] < minPotionValue) {
                    lower = mid+1;
                }
                else {
                    upper = mid;
                }
            }

            if ((double)potions[lower] < minPotionValue) {
                //dont include lower
                ret[i] = potions.length-1-lower;
            }
            else {
                //include lower
                ret[i] = potions.length-lower;
            }
        }

        return ret;
    }
}
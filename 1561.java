class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int i = 0;
        int j = piles.length-1;

        int ret = 0;

        while (i < j) {
            ret += piles[j-1];
            j -= 2;
            i++;
        }

        return ret;
    }
}
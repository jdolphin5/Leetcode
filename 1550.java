class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int i = 0;
        int j = 0;

        while (j < arr.length) {
            if (arr[j] % 2 == 1) {
                j++;
            }
            else {
                j++;
                i = j;
            }

            if (j - i == 3) return true;
        }

        return false;
    }
}
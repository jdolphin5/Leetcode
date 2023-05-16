class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int lower = 0;
        int upper = n-1;
        int mid = 0;
        int h = 0;
        while (lower <= upper) {
            mid = lower + (upper - lower) / 2;
            if (n - mid > citations[mid]) {
                lower = mid + 1;
            }
            else {
                h = n - mid;
                upper = mid - 1;
            }
        }

        return h;
    }
}
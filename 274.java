class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int lower = 0;
        int upper = citations.length;

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;

            if (citations[mid] >= (citations.length - mid)) {
                upper = mid;
            }
            else {
                lower = mid+1;
            }
        }

        return citations.length - lower;
    }
}
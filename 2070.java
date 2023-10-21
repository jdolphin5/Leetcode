class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[1] - b[1]);

        int[] ret = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            for (int j = items.length-1; j >= 0; j--) {
                if (items[j][0] <= queries[i]) {
                    ret[i] = items[j][1];
                    break;
                }
            }
        }

        return ret;
    }
}
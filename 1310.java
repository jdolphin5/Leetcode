class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ret = new int[queries.length];

        int[] xorArr = new int[arr.length];
        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            xorArr[i] = xor;
        }

        //System.out.println(Arrays.toString(xorArr));

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            a--;
            if (a == -1) {
                ret[i] = xorArr[b];
                continue;
            }

            ret[i] = xorArr[a] ^ xorArr[b];
        }

        return ret;
    }
}
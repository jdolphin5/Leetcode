class Solution {
    public int[] sortByBits(int[] arr) {
        int[][] arrWithBitCount = new int[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            arrWithBitCount[i][0] = Integer.bitCount(arr[i]);
            arrWithBitCount[i][1] = arr[i];
        }

        Arrays.sort(arrWithBitCount, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] ret = new int[arr.length];

        for (int i = 0; i < arrWithBitCount.length; i++) {
            ret[i] = arrWithBitCount[i][1];
        }

        return ret;
    }
}
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] bucket = new int[200001];

        for (int i = 0; i < nums1.length; i++) {
            bucket[nums1[i][0]] += nums1[i][1];
        }
        for (int i = 0; i < nums2.length; i++) {
            bucket[nums2[i][0]] += nums2[i][1];
        }

        int size = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) size++;
        }

        int[][] res = new int[size][2];

        int curIndex = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) {
                res[curIndex][0] = i;
                res[curIndex][1] = bucket[i];
                curIndex++;
            }
        }

        return res;

    }
}
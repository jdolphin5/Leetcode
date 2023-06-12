class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        int[] res = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            bucket[arr1[i]]++;
        }

        int x = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < bucket[arr2[i]]; j++) {
                res[x] = arr2[i];
                x++;
            }
            bucket[arr2[i]] = 0;
        }

        int[] leftOver = new int[arr1.length-x];

        int p = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                leftOver[p] = i;
                p++;
                bucket[i]--;
            }
        }
        Arrays.sort(leftOver);
        //System.out.println(Arrays.toString(leftOver));
        for (int i = 0; i < leftOver.length; i++) {
            res[x] = leftOver[i];
            x++;
        }

        return res;

    }
}
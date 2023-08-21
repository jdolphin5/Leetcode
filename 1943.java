class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> ret = new ArrayList<>();
        long[] paintColorChanges = new long[100002]; // 1-indexed
        boolean[] isChange = new boolean[100002];
        long sum = 0;
        int intervalStart = 0;

        for (int[] seg : segments) {
            paintColorChanges[seg[0]] += seg[2];
            paintColorChanges[seg[1]] -= seg[2];
            isChange[seg[0]] = true;
            isChange[seg[1]] = true;
        }

        for (int i = 1; i < paintColorChanges.length; i++) {
            if (isChange[i] && sum > 0) {
                List<Long> myList = new ArrayList<>();
                myList.add((long)intervalStart);
                myList.add((long)i);
                myList.add(sum);
                ret.add(myList);
            }

            if (isChange[i]) {
                intervalStart = i;
            }

            sum += paintColorChanges[i];
        }

        return ret;
    }
}
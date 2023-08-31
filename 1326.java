class Solution {
    public int minTaps(int n, int[] ranges) {
        int i = 0;
        int ret = 0;
        int best = 0;

        while (i < n) {
            boolean success = false;

            for (int j = 0; j < ranges.length; j++) {
                int num = ranges[j];
            
                if (j - num <= i && j + num > best) {
                    best = j + num;
                    success = true;
                }
            }

            if (!success) return -1;

            i = best;
            ret++;
        }

        return ret;
    }
}
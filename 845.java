class Solution {
    public int longestMountain(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }

        int ret = 0;

        int curIncreasingLen = 1;
        int curDecreasingLen = 1;

        boolean hasDecreased = false;
        boolean hasIncreased = false;

        for (int i = 0; i < arr.length-1; i++) {
            int next = arr[i+1];
            int cur = arr[i];

            if (next > cur) {
                if (hasDecreased) {
                    curIncreasingLen = 1;
                    hasDecreased = false;
                }
                curIncreasingLen++;
                hasIncreased = true;
            }
            else if (next < cur) {
                if (hasIncreased) {
                    curDecreasingLen = 1;
                    hasIncreased = false;
                }
                curDecreasingLen++;
                hasDecreased = true;
            }
            else {
                curIncreasingLen = 1;
                curDecreasingLen = 1;
            }

            if (hasDecreased && curIncreasingLen > 1 && curDecreasingLen > 1)
                ret = Math.max(ret, curIncreasingLen + curDecreasingLen - 1);
        }

        return ret;
    }
}
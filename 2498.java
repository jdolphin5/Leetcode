class Solution {
    private boolean canMake(TreeSet<Integer> myTreeSet, int maxLen, int cur, int maxVal, boolean reachedEnd) {
        //System.out.println(cur);
        if (!reachedEnd) {
            Integer next = myTreeSet.floor(cur+maxLen);
            if (next == null) return false;
            myTreeSet.remove(next);
            if (next == maxVal) {
                reachedEnd = true;
            }
            return canMake(myTreeSet, maxLen, next, maxVal, reachedEnd);
        }
        else {
            Integer next = myTreeSet.ceiling(cur-maxLen);
            if (next == null) return false;
            myTreeSet.remove(next);
            if (next == 0) {
                return true;
            }
            return canMake(myTreeSet, maxLen, next, maxVal, reachedEnd);
        }
    }

    public int maxJump(int[] stones) {
        TreeSet<Integer> myTreeSet = new TreeSet<>();
        int maxVal = stones[stones.length-1];

        for (int num : stones) {
            myTreeSet.add(num);
        }

        int lower = 0;
        int upper = maxVal;

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;

            if (canMake(new TreeSet<>(myTreeSet), mid, 0, maxVal, false)) {
                upper = mid;
            }
            else {
                lower = mid+1;
            }
        }

        return lower;
    }
}
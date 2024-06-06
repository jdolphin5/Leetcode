class Solution {
    private boolean recur(int[] hand, int groupSize, int i, int offset, int size) {
        if (i == hand.length) {
            if (offset < groupSize)
                return false;
            return true;
        }

        if (offset < groupSize) {
            if (hand[i] != size) {
                if (!recur(hand, groupSize, i+1, offset, size)) {
                    return false;
                }
            }

            else {
                hand[i] = -1;

                if (!recur(hand, groupSize, i+1, offset+1, size+1)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);

        int j = 0;

        while (j < hand.length) {
            if (hand[j] >= 0) {
                int size = hand[j];

                if (!recur(hand, groupSize, j, 0, size))
                    return false;
            }

            j++;
        }

        return true;
    }
}
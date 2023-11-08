class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] needed = new int[capacity.length];

        for (int i = 0; i < needed.length; i++) {
            needed[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(needed);

        int remRocks = additionalRocks;
        int i = 0;

        while (remRocks > 0 && i < needed.length) {
            if (remRocks >= needed[i]) {
                remRocks -= needed[i];
                i++;
            }
            else {
                break;
            }
        }

        return i;
    }
}
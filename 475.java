class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> heatersTreeSet = new TreeSet<>();

        for (int num : heaters) {
            heatersTreeSet.add(num);
        }

        int ret = 0;

        for (int house : houses) {
            int minDiff = Integer.MAX_VALUE;

            Integer lower = heatersTreeSet.floor(house);
            Integer higher = heatersTreeSet.ceiling(house);

            if (lower != null)
                minDiff = Math.min(minDiff, Math.abs(house - lower));
            if (higher != null)
                minDiff = Math.min(minDiff, Math.abs(house - higher));

            ret = Math.max(ret, minDiff);
        }

        return ret;
    }
}
class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        PriorityQueue<Integer> maybeGood = new PriorityQueue<>();
        Set<Integer> notGood = new HashSet<>();

        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                notGood.add(fronts[i]);
            }
            else {
                maybeGood.offer(fronts[i]);
                maybeGood.offer(backs[i]);
            }
        }
        while (!maybeGood.isEmpty()) {
            int num = (int)maybeGood.poll();
            if (!notGood.contains(num)) {
                return num;
            }
        }
        return 0;
    }
}
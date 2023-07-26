class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int[] firstMouseDiffs = new int[reward1.length];

        for (int i = 0; i < reward1.length; i++) {
            firstMouseDiffs[i] = reward1[i] - reward2[i];
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

        Set<Integer> firstMouseIndices = new HashSet<>();

        for (int i = 0; i < firstMouseDiffs.length; i++) {
            pq.offer(new Pair(firstMouseDiffs[i], i));
        }

        int res = 0;
        while (k > 0) {
            Pair<Integer, Integer> myPair = pq.poll();
            res += reward1[myPair.getValue()];
            firstMouseIndices.add(myPair.getValue());
            k--;
        }

        for (int i = 0; i < reward2.length; i++) {
            if (firstMouseIndices.contains(i))
                continue;
            res += reward2[i];
        }

        return res;
    }
}
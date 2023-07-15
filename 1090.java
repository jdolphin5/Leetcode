class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {

        int ret = 0;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getKey() - a.getKey());
        int[] labelBucket = new int[1000001];
        
        for (int i = 0; i < values.length; i++) {
            Pair<Integer, Integer> myPair = new Pair(values[i], labels[i]);
            pq.offer(myPair);
        }

        int i = 0;
        while (i < numWanted && !pq.isEmpty()) {
            Pair<Integer, Integer> myPair = pq.poll();
            int val = myPair.getValue();
            if (labelBucket[val] < useLimit) {
                labelBucket[val]++;
                i++;
                ret += myPair.getKey();
            }
        }

        return ret;
    }
}
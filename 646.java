class Solution {
    public int findLongestChain(int[][] pairs) {
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] * 1000 + a[0] - b[1] * 1000 - b[0]);
        for (int[] onePair : pairs) {
            pq.offer(onePair);
        }
        int curLast = -1001;

        while (!pq.isEmpty()) {
            int[] onePair = pq.poll();
            if (curLast < onePair[0]) {
                curLast = onePair[1];
                count++;
            }   
        }

        return count;

    }
}
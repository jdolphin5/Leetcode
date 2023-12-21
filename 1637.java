class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        for (int[] p : points) {
            pq.offer(p[0]);
        }

        int last = pq.poll();
        int ret = 0;

        while (!pq.isEmpty()) {
            ret = Math.max(ret, pq.peek() - last);
            last = pq.poll();
        }

        return ret;
    }
}
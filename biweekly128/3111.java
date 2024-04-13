class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        
        for (int[] point : points) {
            pq.offer(point[0]);
        }
        
        int first = 0;
        int ret = 0;
        
        while (!pq.isEmpty()) {
            first = pq.peek();
            
            while (!pq.isEmpty() && first + w >= pq.peek()) {
                pq.poll();
            }
            
            ret++;
        }
        
        return ret;
    }
}
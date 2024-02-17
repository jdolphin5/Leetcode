class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i-1]) {
                pq.offer(heights[i]-heights[i-1]);
                
                if (ladders < pq.size()) {
                    bricks -= pq.poll();
                }
            }

            if (bricks < 0) return i-1;
        }

        return heights.length-1;
    }
}
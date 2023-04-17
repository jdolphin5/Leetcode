class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < stones.length; i++) {
            pQueue.add(stones[i]);
        }

        int x = 0;
        int y = 0;
        while (!pQueue.isEmpty()) {
            y = pQueue.poll();
            if (!pQueue.isEmpty()) {
                x = pQueue.poll();
                System.out.println(x);
            }
            if (x == y) {
                x = 0;
                y = 0;
            }
            else if (x > 0) {
                y = y - x;
                x = 0;
                pQueue.add(y);
            }
        }

        return y;
    }
}
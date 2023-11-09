class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : piles) {
            pq.offer(num);
        }

        while (k > 0) {
            int cur = pq.poll();
            int subtract = (int)Math.floor((double)cur/2);
            k--;
            pq.offer(cur - subtract);
        }

        int ret = 0;

        while (!pq.isEmpty()) {
            ret += pq.poll();
        }

        return ret;
    }
}
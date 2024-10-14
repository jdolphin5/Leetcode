class Solution {
    public long maxKelements(int[] nums, int k) {
        long ret = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            pq.offer(num);
        }

        while (k-- > 0) {
            int num = pq.poll();
            ret += num;

            pq.offer((int)Math.ceil((double)num / 3.0));
        }

        return ret;
    }
}
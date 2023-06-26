class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long ret = 0;
        int n = costs.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        if (2 * candidates >= n) { //add all
            for (int i = 0; i < n; i++) {
                pq.offer(new int[] {costs[i], 0});
            }
        } 
        else {
            for (int i = 0; i < candidates; i++) {
                pq.offer(new int[] {costs[i], 0}); //left of left
                pq.offer(new int[] {costs[n-1-i], 1}); //left of right
            }
        }

        int left = candidates;
        int right = n-candidates-1;

        while (k > 0) {
            k--;
            int[] choose = pq.poll();
            ret += choose[0];

            if (left > right) {
                continue;
            }

            if (choose[1] == 0) {
                pq.offer(new int[] {costs[left++], 0});
            }
            else {
                pq.offer(new int[] {costs[right--], 1});
            }
        }

        return ret;
    }
}
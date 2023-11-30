class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int time[] : times){
            adj.get(time[0]).add(new int[] { time[1], time[2] } );
        }

        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { k, 0 } );

        dist[k] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll()[0];
            for (int p[] : adj.get(u)) {
                int v = p[0];
                int w = p[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[] { v, dist[v] } );
                }
            }
        }

        //if (dist[node2] == Integer.MAX_VALUE) {
        //    return -1;
        //}

        int ret = -1;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ret = Math.max(ret, dist[i]);
        }

        return ret;
    }
}
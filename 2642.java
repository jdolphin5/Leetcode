class Graph {
    List<List<int[]>> adj;
    int n;

    public Graph(int n, int[][] edges) {
        adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        this.n = n;

        for(int edge[] : edges){
            adj.get(edge[0]).add(new int[] { edge[1], edge[2] } );
        }
    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[] { edge[1], edge[2] } );
    }
    
    public int shortestPath(int node1, int node2) {
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { node1, 0 } );

        dist[node1] = 0;

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

        if (dist[node2] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */

 /*
    Dijkstra
 */
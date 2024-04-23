class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer>[] graph =  new ArrayList[n];
        int[] degrees = new int[n];

	    for(int i = 0; i < graph.length; i++){
	        graph[i] = new ArrayList<>();
	    }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degrees[i] <= 1) {
                q.offer(i);
            }
        }

        while (n > 2) {
            int size = q.size();
            n -= size;

            while (size-- > 0) {
                int leaf = q.poll();

                for (int x : graph[leaf]) {
                    if (--degrees[x] == 1) {
                        q.offer(x);
                    }
                }
            }
        }

        return new ArrayList<>(q);
    }
}
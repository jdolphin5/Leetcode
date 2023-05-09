class Solution {

    private int find(int i, int[] edge) {
        List<Integer> paths = new ArrayList<>();

        while (edge[i] >= 0) {
            paths.add(i);
            i = edge[i];
        }

        for (int path: paths) {
            edge[path] = i;
        }
        return i;
    }

    private void union(int i, int j, int[] edge) {
        int iParent = find(i, edge);
        int jParent = find(j, edge);

        if (iParent != jParent) {
            edge[iParent] = jParent;
        }

    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] edge = new int[2*(int)Math.pow(10,5)];
        Arrays.fill(edge, -1);

        for (int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1], edge);
        }

        if (find(source, edge) == find(destination, edge)) return true;

        return false;
        

        
    }
}
class Solution {

    private int find(int i, int[] graph) {
        List<Integer> paths = new ArrayList<>();

        //walk up to parent
        while (graph[i] > 0) {
            paths.add(i);
            i = graph[i]; //will point to parent when break
        }

        //path compression
        for (Integer path : paths) {
            graph[path] = i;
        }

        return i;
    }

    private boolean union(int i, int j, int[] graph) {
        int iParent = find(i, graph);
        int jParent = find(j, graph);

        //System.out.println("i: " + i + " j: " + j + " iParent: " + iParent + " jParent: " + jParent);

        if (iParent < jParent)
            graph[iParent] = jParent;
        else if (iParent > jParent)
            graph[jParent] = iParent;
        else 
            return false;

        return true;
    }


    public int[] findRedundantConnection(int[][] edges) {
        int[] graph = new int[edges.length+1];
        Arrays.fill(graph, -1);
        
        for (int i = 0; i < edges.length; i++) {
            if (!union(edges[i][0], edges[i][1], graph))
                return edges[i];
        }

        return edges[0];

    }
}
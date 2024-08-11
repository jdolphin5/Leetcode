class Solution {
    private int countNodesInSubtrees(ArrayList<Integer>[] graph, int node, Set<Integer> visited, int[] count) {
        int ret = 1;
        visited.add(node);

        for (Integer nextNode : graph[node]) {
            if (visited.contains(nextNode)) {
                continue;
            }
            count[nextNode] = countNodesInSubtrees(graph, nextNode, visited, count);
            ret += count[nextNode];
        }

        //System.out.println("node: " + node + " count: " + ret);

        return ret;
    }

    private int countGoodNodesOfSubtree(ArrayList<Integer>[] graph, int node, Set<Integer> visited, int[] count) {
        int ret = 0;
        visited.add(node);

        int cur = -1;
        boolean good = true;

        for (Integer nextNode : graph[node]) {
            if (visited.contains(nextNode)) continue;

            ret += countGoodNodesOfSubtree(graph, nextNode, visited, count);

            if (cur != -1 && cur != count[nextNode])
                good = false;
            
            cur = count[nextNode];
        }

        if (good)
            ret++;

        return ret;
    }

    public int countGoodNodes(int[][] edges) {
        ArrayList<Integer>[] graph =  new ArrayList[100001];
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();
        int[] count = new int[100001];
	    
        for(int i = 0; i < graph.length; i++){
	        graph[i] = new ArrayList<>();
	    }

        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];

            graph[a].add(b);
            graph[b].add(a);
        }


        countNodesInSubtrees(graph, 0, visited, count);

        return countGoodNodesOfSubtree(graph, 0, visited2, count);
    }
}
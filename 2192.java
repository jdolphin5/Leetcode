class Solution {
    private List<Integer> getAncestorsList(int n, Map<Integer, List<Integer>> dp, List<Integer>[] graph, int node) {
        Set<Integer> ret = new HashSet<>();

        if (dp.get(node) != null) {
            return dp.get(node);
        }

        for (int node2 : graph[node]) {
            ret.add(node2);
            ret.addAll(getAncestorsList(n, dp, graph, node2));
        }

        List<Integer> resList = new ArrayList<>(ret);
        Collections.sort(resList);

        dp.put(node, resList);

        return resList;
    } 

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            List<Integer> newList = new ArrayList<>();
            graph[i] = newList;
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph[b].add(a);
        }

        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, List<Integer>> dp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            ret.add(getAncestorsList(n, dp, graph, i));
        }

        return ret;
    }
}
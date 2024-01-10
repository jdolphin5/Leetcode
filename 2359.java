class Solution {
    private void traverse(Map<Integer, Integer> myMap, int idx, int node, int[] edges) {
        if (node == -1 || myMap.containsKey(node)) {
            return;
        }

        myMap.put(node, idx);

        traverse(myMap, idx+1, edges[node], edges);
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> myMap = new HashMap<>();
        Map<Integer, Integer> myMap2 = new HashMap<>();
        
        traverse(myMap, 0, node1, edges);
        traverse(myMap2, 0, node2, edges);

        int ret = -1;
        int dist = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if (myMap2.get(key) != null) {
                int curDist = Math.max(myMap.get(key), myMap2.get(key));
                
                if (dist > curDist) {
                    dist = curDist;
                    ret = key;
                }
                else if (dist == curDist) {
                    ret = Math.min(ret, key);
                }
            }
        }

        return ret;
    }
}
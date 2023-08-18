class Solution {
    private int countConnected(int i, int[][] roads) {
        int ret = 0;
        for (int j = 0; j < roads.length; j++) {
            if (roads[j][0] == i || roads[j][1] == i)
            ret++;
        }
        return ret;
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        int max = 0;
        int[] connectedRoads = new int[n];
        Set<Pair<Integer, Integer>> roadsSet = new HashSet<>();
        for (int[] road : roads) {
            Pair<Integer, Integer> myPair = new Pair(road[0], road[1]);
            roadsSet.add(myPair);
        }

        for (int i = 0; i < n; i++) {
            connectedRoads[i] = countConnected(i, roads);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int count = 0;
                count += connectedRoads[i];
                count += connectedRoads[j];
                if (roadsSet.contains(new Pair(new Integer(i), new Integer(j))) || 
                    roadsSet.contains(new Pair(new Integer(j), new Integer(i))))
                    count--;
                //System.out.println("i: " + i + " j: " + j + " Count: " + count);
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
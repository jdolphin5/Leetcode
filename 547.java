class Solution {

    private int find(int i, int[] cities) {
        List<Integer> paths = new ArrayList<>();

        //walk up to parent
        while (cities[i] > 0) {
            paths.add(i);
            i = cities[i]; //will point to parent when break
        }

        //path compression
        for (Integer path : paths) {
            cities[path] = i;
        }

        return i;
    }

    private void union(int i, int j, int[] cities) {
        int iParent = find(i, cities);
        int jParent = find(j, cities);
        if (iParent == jParent) return;

        int iSize = cities[iParent];
        int jSize = cities[jParent];

        //because size is neg, the bigger one is more negative
        if (iSize < jSize) {
            cities[iParent] += jSize;
            cities[jParent] = iParent;
        }
        else {
            cities[jParent] += iSize;
            cities[iParent] = jParent;
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int[] cities = new int[isConnected.length];
        
        Arrays.fill(cities, -1);

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, cities);
                }
            }
        }

        int count = 0;
        for (int num : cities) {
            if (num < 0) count++;
        }

        return count;
    }
}
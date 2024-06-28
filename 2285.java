class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] cityRoadCount = new int[n];

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];

            cityRoadCount[a]++;
            cityRoadCount[b]++;
        }

        Arrays.sort(cityRoadCount);
        long ret = 0;

        for (int i = 0; i < cityRoadCount.length; i++) {
            ret += 1L * cityRoadCount[i] * (i+1);
        }

        return ret;
    }
}
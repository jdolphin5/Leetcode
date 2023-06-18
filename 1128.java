class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int[] cur = dominoes[i];
            int higher = Math.max(cur[0], cur[1]);
            int lower = Math.min(cur[0], cur[1]);

            int key = higher*10 + lower;

            if (!myMap.containsKey(key)) {
                myMap.put(key, 0);
            }

            count += myMap.get(key);
            myMap.put(key, myMap.get(key) + 1); 
        }

        return count;
    }
}
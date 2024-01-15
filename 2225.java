class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winnerSet = new HashSet<>();
        Map<Integer, Integer> loserMap = new HashMap<>();

        for (int[] match : matches) {
            winnerSet.add(match[0]);
            loserMap.put(match[1], loserMap.getOrDefault(match[1], 0) + 1);
        }

        List<Integer> winnerList = new ArrayList<>(winnerSet);

        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();

        for (Integer winner : winnerList) {
            if (loserMap.get(winner) == null) {
                ans1.add(winner);
            }
        }

        for (Map.Entry<Integer, Integer> entry : loserMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value == 1) {
                ans2.add(key);
            }
        }

        Collections.sort(ans1);
        Collections.sort(ans2);

        ret.add(ans1);
        ret.add(ans2);

        return ret;
    }
}
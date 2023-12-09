class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        TreeMap<Integer, Integer> trainersTreeMap = new TreeMap<>();
        int ret = 0;

        for (int num : trainers) {
            trainersTreeMap.put(num, trainersTreeMap.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(players);

        for (int i = players.length-1; i >= 0; i--) {
            Integer key = trainersTreeMap.ceilingKey(players[i]);

            if (key != null) {
                ret++;
                trainersTreeMap.put(key, trainersTreeMap.get(key) - 1);

                if (trainersTreeMap.get(key) == 0){ 
                    trainersTreeMap.remove(key);
                }
            }
        }

        return ret;
    }
}
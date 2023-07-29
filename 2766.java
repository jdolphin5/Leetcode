class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {

        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> posCountMap = new HashMap<>();
        for (int num : nums) {
            int toAdd = posCountMap.getOrDefault(num, 0) + 1;
            posCountMap.put(num, toAdd);
        }

        for (int i = 0; i < moveTo.length; i++) {
            if (moveTo[i] != moveFrom[i]) {
                int fromAdd = posCountMap.getOrDefault(moveFrom[i], 0);
                int toAdd = posCountMap.getOrDefault(moveTo[i], 0);
                posCountMap.put(moveTo[i], fromAdd + toAdd);
                posCountMap.put(moveFrom[i], 0);
            }
            //System.out.println("i: " + i + " marbleBucket[moveTo[i]] + " + marbleBucket[moveTo[i]]);
        }

        for (Map.Entry<Integer, Integer> entry : posCountMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > 0) {
                res.add(key);
            }
        }
        Collections.sort(res);

        return res;
    }
}
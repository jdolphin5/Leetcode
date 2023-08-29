class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> basket1Map = new HashMap<>();
        Map<Integer, Integer> basket2Map = new HashMap<>();

        for (int num : basket1) {
            basket1Map.put(num, basket1Map.getOrDefault(num, 0) + 1);
        }

        for (int num : basket2) {
            basket2Map.put(num, basket2Map.getOrDefault(num, 0) + 1);
        }

        List<Integer> basket1Missing = new ArrayList<>();
        List<Integer> basket2Missing = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        Map<Integer, Integer> mergeMap = new HashMap<>();
        mergeMap.putAll(basket1Map);
        mergeMap.putAll(basket2Map);

        for (Integer key : mergeMap.keySet()) {
            int diff = 0;
            int basket1Val = basket1Map.getOrDefault(key, 0);
            int basket2Val = basket2Map.getOrDefault(key, 0);

            diff = Math.abs(basket1Val - basket2Val);

            if (diff % 2 == 1) {
                return -1;
            }

            if (basket1Val > basket2Val) {
                for (int j = 0; j < (basket1Val-basket2Val)/2; j++) {
                    basket1Missing.add(key);
                }

            }
            else if (basket2Val > basket1Val) {
                for (int j = 0; j < (basket2Val-basket1Val)/2; j++) {
                    basket2Missing.add(key);
                }

            }

            if (basket1Val > 0) {
                min = Math.min(min, key);
            }

            if (basket2Val > 0) {
                min = Math.min(min, key);
            }
        }

        if (basket1Missing.size() != basket2Missing.size())
            return -1;

        Collections.sort(basket1Missing);
        Collections.sort(basket2Missing, Collections.reverseOrder());

        long ret = 0;

        for (int i = 0; i < basket1Missing.size(); i++) {
            int val = Math.min(basket1Missing.get(i), basket2Missing.get(i));
            ret += Math.min(val, 2*min);
        }

        return ret;
    }
}
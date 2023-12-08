class Solution {
    public int numRescueBoats(int[] people, int limit) {
        TreeMap<Integer, Integer> myTreeMap = new TreeMap<>();

        for (int weight : people) {
            myTreeMap.put(weight, myTreeMap.getOrDefault(weight, 0) + 1);
        }

        int total = people.length;
        int ret = 0;
        int ct = 0;

        while (ct < total) {
            int cur = limit;
            boolean good = true;
            int numPerBoat = 0;

            while (good && cur > 0 && numPerBoat < 2) {
                Integer maxLessThanCur = myTreeMap.floorKey(cur);
                if (maxLessThanCur == null) {
                    good = false;
                    continue;
                }
                cur -= maxLessThanCur;
                myTreeMap.put(maxLessThanCur, myTreeMap.get(maxLessThanCur) - 1);

                if (myTreeMap.get(maxLessThanCur) == 0) {
                    myTreeMap.remove(maxLessThanCur);
                }

                numPerBoat++;
                ct++;
            }

            ret++;
        }

        return ret;
    }
}
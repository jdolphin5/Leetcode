class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> myMap = new HashMap<>();
        List<Integer> dryLakeIndices = new ArrayList<>();
        int[] ret = new int[rains.length];
        Arrays.fill(ret, -1);
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                if (myMap.containsKey(rains[i])) {
                    int size = dryLakeIndices.size();
                    if (size == 0 || (size > 0 && dryLakeIndices.get(size-1) < myMap.get(rains[i]))) 
                        return new int[0];
                    else {
                        int x = 0;
                        for (int num : dryLakeIndices) {
                            if (num >= myMap.get(rains[i])) {
                                x = num;
                                break;
                            }
                        }
                        dryLakeIndices.remove(new Integer(x));
                        ret[x] = rains[i];
                        myMap.put(rains[i], i);
                    }
                }
                else
                    myMap.put(rains[i], i);
            }
            else if (rains[i] == 0) {
                dryLakeIndices.add(i);
            }
        }
        for (int i : dryLakeIndices) {
            ret[i] = 1;
        }
        return ret;
    }
}
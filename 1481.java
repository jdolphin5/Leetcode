class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : arr) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }
        int ret = numCountMap.size();
        int[] bucket = new int[10001];
        if (k == 0) return ret;

        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            bucket[count]++;
        }

        outerloop:
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) {
                for (int j = bucket[i]; j > 0; j--) {
                    for (int x = 0; x < i; x++) {
                        //System.out.println("i: " + i + " j : " + j + " x: " + x);
                        k--;
                        if (k == 0 && x != i-1) break outerloop;
                    }
                    ret--;
                    if (k == 0) break outerloop;
                }
            }
        }


        return ret;
        
    }
}
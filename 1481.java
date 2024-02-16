class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        TreeMap<Integer, Integer> myTreeMap = new TreeMap<>();
        int countOfNumbers = 0;

        for (int num : arr) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            myTreeMap.put(entry.getValue(), myTreeMap.getOrDefault(entry.getValue(), 0) + 1);
            countOfNumbers++;
        }

        boolean cont = true;

        while (cont) {
            cont = false;
            int x = Integer.MAX_VALUE;
            
            if (myTreeMap.size() > 0)
                x = myTreeMap.firstKey();

            if (k >= x) {
                cont = true;
                k -= x;
                myTreeMap.put(x, myTreeMap.get(x) - 1);
                
                if (myTreeMap.get(x) == 0) {
                    myTreeMap.remove(x);
                }

                countOfNumbers--;
            }
        }

        return countOfNumbers;
    }
}
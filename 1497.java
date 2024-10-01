class Solution {
    private void decrementMap(Map<Integer, Integer> myMap, int num) {
        myMap.put(num, myMap.get(num) - 1);

        if (myMap.get(num) == 0) {
            myMap.remove(num);
        }
    }

    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> myMap = new HashMap<>();

        Arrays.sort(arr);

        for (int num : arr) {
            num = ((num % k) + k) % k;
            if (myMap.containsKey(num * -1)) {
                decrementMap(myMap, (num * -1));
            }
            else if (myMap.containsKey(k - num)) {
                decrementMap(myMap, k - num);
            }
            else {
                myMap.put(num, myMap.getOrDefault(num, 0) + 1);
            }
        }

        System.out.println(myMap.toString());

        return myMap.size() == 0;
    }
}
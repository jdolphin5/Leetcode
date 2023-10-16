class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            numsMap.put(arr[i], i);
        }

        int maxCt = 0;

        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                int num = arr[i];
                int num2 = arr[j];
                int ct = 0;
                
                while (numsMap.containsKey(num + num2)) {
                    ct = Math.max(2, ct);
                    ct++;
                    int temp = num;
                    num = num2;
                    num2 = num + temp;
                    maxCt = Math.max(maxCt, ct);
                }
            }
        }

        return maxCt;
    }
}
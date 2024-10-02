class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copyArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }

        Arrays.sort(copyArr);
        Map<Integer, Integer> valueToRankMap = new HashMap<>();
        int offset = 0;
        int last = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (copyArr[i] == last) {
                offset++;
                continue;
            }

            valueToRankMap.put(copyArr[i], i + 1 - offset);
            last = copyArr[i];
        }

        int[] ret = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ret[i] = valueToRankMap.get(arr[i]);
        }

        return ret;
    }
}
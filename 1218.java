class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int max = 0;
        Map<Integer, Integer> dp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) 
        {
            if (dp.containsKey(arr[i] - difference)) {
                dp.put(arr[i], dp.get(arr[i] - difference) + 1);
            } else {
                dp.put(arr[i], 1);
            }
            max = Math.max(dp.get(arr[i]), max);
        }
        return max;
    }
}
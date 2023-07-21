class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            myMap.put(nums[i], i);
        }

        for (int[] arr : operations) {
            int i = myMap.get(arr[0]);
            myMap.put(arr[1], i);
            myMap.remove(arr[0]);
            nums[i] = arr[1];
        }

        return nums;
        
    }
}
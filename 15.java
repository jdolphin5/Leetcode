class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int k = 0;
        Set<List<Integer>> result = new HashSet<>();
        while (i < nums.length-2) {
            j = i+1;
            k = nums.length-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> myList = new ArrayList<>();
                    myList.add(nums[i]);
                    myList.add(nums[j]);
                    myList.add(nums[k]);
                    result.add(myList);
                    j++;
                }
                else if (sum < 0) j++;
                else k--;
            }
            i++;
        }

        return new ArrayList<>(result);
    }
}
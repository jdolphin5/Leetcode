class Solution {
    private void removeOne(int num, TreeMap<Integer, Integer> myTreeMap) {
        if (myTreeMap.get(num) == 1) {
            myTreeMap.remove(num);
        }
        else {
            myTreeMap.put(num, myTreeMap.get(num)-1);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int[] ret = new int[nums.length-k+1];
        TreeMap<Integer, Integer> myTreeMap = new TreeMap<>();
        while (j < k) {
            myTreeMap.put(nums[j], myTreeMap.getOrDefault(nums[j], 0) + 1);
            j++;
        }
        ret[i] = myTreeMap.lastEntry().getKey();

        while (j < nums.length) {
            removeOne(nums[i], myTreeMap);
            i++;
            myTreeMap.put(nums[j], myTreeMap.getOrDefault(nums[j], 0) + 1);
            j++;
            ret[i] = myTreeMap.lastEntry().getKey();
        }
        return ret;
    }
}
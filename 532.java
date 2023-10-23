public class Solution {
    public int findPairs(int[] nums, int k) {
        int ret = 0;
        Map<Integer, List<Integer>> myMap = new HashMap<>();
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> myList = myMap.getOrDefault(nums[i], new ArrayList<>());
            myList.add(i);
            myMap.put(nums[i], myList);
        }

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i]))
                continue;
            seen.add(nums[i]);

            List<Integer> myList1 = myMap.getOrDefault(nums[i]-k, new ArrayList<>());
            List<Integer> myList2 = myMap.getOrDefault(k+nums[i], new ArrayList<>());

            int list1Ct = 0;
            if (myList1.contains(i)) {
                list1Ct = myList1.size() > 1 ? 1 : 0;
            }
            else {
                list1Ct = myList1.size() > 0 ? 1 : 0;
            }

            int list2Ct = 0;
            if (myList2.contains(i)) {
                list2Ct = myList2.size() > 1 ? 1 : 0;
            }
            else {
                list2Ct = myList2.size() > 0 ? 1 : 0;
            }
            if (nums[i]-k == k + nums[i]) {
                list2Ct = 0;
            }

            myMap.remove(nums[i]);

            ret += list1Ct + list2Ct;
        }

        return ret;
    }
} 532 {
    
}

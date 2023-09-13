class Solution {

    private void removeOne(TreeMap<Integer, Integer> myTreeMap, int key) {
        if (myTreeMap.get(key) == 1) {
            myTreeMap.remove(key);
        }

        else {
            myTreeMap.put(key, myTreeMap.get(key) - 1);
        }
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> myTreeMap = new TreeMap<>();

        for (int num : nums1) {
            myTreeMap.put(num, myTreeMap.getOrDefault(num, 0) + 1);
        }

        int[] ret = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            Integer higherKey = myTreeMap.higherKey(nums2[i]);
            if (higherKey == null) {
                Integer firstKey = myTreeMap.firstKey();
                ret[i] = firstKey;
                removeOne(myTreeMap, firstKey);
            }
            else {
                ret[i] = higherKey;
                removeOne(myTreeMap, higherKey);
            }
        }

        return ret;
    }
}
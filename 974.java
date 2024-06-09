class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ret = 0;
        Map<Integer, Integer> sumCtMap = new HashMap<>();
        sumCtMap.put(0, 1);
        int prefix = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i] % k + k) % k;
            ret += sumCtMap.getOrDefault(prefix, 0);
            sumCtMap.put(prefix, sumCtMap.getOrDefault(prefix, 0) + 1);

            //System.out.println("i: " + i + " ret: " + ret + " - " + sumCtMap.toString());
        }

        return ret;
    }
}
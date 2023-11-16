class Solution {
    String ret = "";

    private void recur(Set<String> numsSet, int i, int n, String cur) {
        if (i == n) {
            if (!numsSet.contains(cur)) {
                ret = cur;
            }

            return;
        }

        if (!ret.equals("")) return;

        String curCopy1 = cur + "0";
        String curCopy2 = cur + "1";

        recur(numsSet, i+1, n, curCopy1);
        recur(numsSet, i+1, n, curCopy2);
    }

    public String findDifferentBinaryString(String[] nums) {
        Set<String> numsSet = new HashSet<>();
        int n = nums[0].length();

        for (String s : nums) {
            numsSet.add(s);
        }

        recur(numsSet, 0, n, "");

        return ret;
    }
}
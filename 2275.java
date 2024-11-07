class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitIndexArr = new int[32];

        for (int i = 0; i < candidates.length; i++) {
            int x = candidates[i];

            String xStr = Integer.toBinaryString(x);

            for (int j = xStr.length()-1; j >= 0; j--) {
                if (xStr.charAt(j) == '1')
                    bitIndexArr[xStr.length()-1-j]++;
            }
        }

        int ret = 0;

        for (int x : bitIndexArr) {
            ret = Math.max(ret, x);
        }

        return ret;
    }
}
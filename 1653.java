class Solution {
    public int minimumDeletions(String s) {
        int[] bBeforeIndex = new int[s.length()];
        int[] aAfterIndex = new int[s.length()];

        int bCount = 0;
        int aCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            bBeforeIndex[i] = bCount;

            if (c == 'b') {
                bCount++;
            }
        }

        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            aAfterIndex[i] = aCount;

            if (c == 'a') {
                aCount++;
            }
        }
        
        int ret = Integer.MAX_VALUE;

        for (int i = 0; i < bBeforeIndex.length; i++) {
            ret = Math.min(ret, bBeforeIndex[i] + aAfterIndex[i]);
        }

        return ret;
    }
}
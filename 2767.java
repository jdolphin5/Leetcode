class Solution {
    private int recur(String s, String[] powersOfFive, int i) {
        if (i > s.length()) {
            return 16;
        }

        if (i == s.length()) {
            return 0;
        }

        int min = 16;

        for (int j = i; j < s.length(); j++) {
            for (int k = 0; k < powersOfFive.length; k++) {
                if (powersOfFive[k].equals(s.substring(i, j+1))) {
                    min = Math.min(min, 1 + recur(s, powersOfFive, j+1));
                }
            }
        }

        return min;
    }

    public int minimumBeautifulSubstrings(String s) {
        String[] powersOfFive = new String[] {"1", "101", "11001", "1111101", "1001110001", "110000110101", "11110100001001"};

        int ret = recur(s, powersOfFive, 0);

        return ret == 16 ? -1 : ret;
    }
}
class Solution {
    private String recur(String pattern, int i, boolean[] used, StringBuilder cur) {
        if (i == pattern.length()+1) {
            return new String(cur);
        }

        String ret = "999999999";

        for (int x = 0; x < 9; x++) {
            if (used[x]) continue;
            if (i == 0 || (pattern.charAt(i-1) == 'I' && (x+1) > Character.getNumericValue(cur.charAt(cur.length()-1))) || (pattern.charAt(i-1) == 'D' && (x+1) < Character.getNumericValue(cur.charAt(cur.length()-1)))) {
                used[x] = true;
                cur.append(x+1);
                String ret2 = recur(pattern, i+1, used, cur);

                if (ret.compareTo(ret2) > 0) {
                    ret = ret2;
                }

                used[x] = false;
                cur.deleteCharAt(cur.length()-1);
            }
        }

        return ret;
    }

    public String smallestNumber(String pattern) {
        return recur(pattern, 0, new boolean[9], new StringBuilder());
    }
}
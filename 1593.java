class Solution {

    private int backtrack(Set<String> mySet, String s, int i) {
        if (i == s.length()) {
            return 0;
        }

        int ret = 0;

        for (int j = i+1; j <= s.length(); j++) {
            String str = s.substring(i, j);

            if (!mySet.contains(str)) {
                mySet.add(str);
                ret = Math.max(ret, 1 + backtrack(mySet, s, j));
                mySet.remove(str);
            }
            else {
                ret = backtrack(mySet, s, i+1);
            }
        }

        return ret;
    }

    public int maxUniqueSplit(String s) {
        Set<String> mySet = new HashSet<>();

        return backtrack(mySet, s, 0);
    }
}
class Solution {
    private boolean isPal(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) {
                return false;
            }
        }

        return true;
    }

    private void recur(List<List<String>> retList, String s, int i, StringBuilder cur, List<String> curList) {
        if (i == s.length()) {
            if (cur.length() == 0)
                retList.add(curList);
            return;
        }

        cur.append(s.charAt(i));

        if (isPal(cur.toString())) {
            List<String> curList2 = new ArrayList<>(curList);
            curList2.add(cur.toString());
            recur(retList, s, i+1, new StringBuilder(), curList2);
        }

        recur(retList, s, i+1, cur, curList);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> retList = new ArrayList<>();

        recur(retList, s, 0, new StringBuilder(), new ArrayList<>());

        return retList;
    }
}
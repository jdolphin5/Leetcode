class Solution {
    private void recur(List<String> ret, String s, int i, String cur) {
        if (i == s.length()) {
            ret.add(cur);
            return;
        }
        
        char c = s.charAt(i);

        if (Character.isDigit(c)) {
            cur = cur + c;
            recur(ret, s, i+1, cur);
        }
        else {
            c = Character.toUpperCase(c);
            recur(ret, s, i+1, cur + c);
            c = Character.toLowerCase(c);
            recur(ret, s, i+1, cur + c);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ret = new ArrayList<>();

        recur(ret, s, 0, "");

        return ret;
    }
}
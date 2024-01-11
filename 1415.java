class Solution {
    private void generateStrings(List<String> ret, int n, int k, int i, String cur, char last, List<Character> charList) {
        if (i == n) {
            ret.add(cur);
            return;
        }

        for (int j = 0; j < charList.size(); j++) {
            if (charList.get(j) != last) {
                generateStrings(ret, n, k, i+1, cur + charList.get(j), charList.get(j), charList);
            }
        }
    }

    public String getHappyString(int n, int k) {
        List<Character> charList = new ArrayList<>();
        charList.add('a');
        charList.add('b');
        charList.add('c');

        List<String> ret = new ArrayList<>();

        generateStrings(ret, n, k, 0, "", ' ', charList);

        return k <= ret.size() ? ret.get(k-1) : "";
    }
}
class Solution {

    private void recur(List<String> ret, StringBuilder cur, String digits, int i, Map<Character, char[]> charMap) {
        if (i == digits.length()) {
            ret.add(new String(cur));
            return;
        }

        char c = digits.charAt(i);
        char[] charArr = charMap.get(c);

        for (int j = 0; j < charArr.length; j++) {
            cur.append(charArr[j]);
            recur(ret, cur, digits, i+1, charMap);
            cur.deleteCharAt(cur.length()-1);
        }


    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> ret = new ArrayList<>();
        Map<Character, char[]> charMap = new HashMap<>();
        charMap.put('2', new char[] {'a', 'b', 'c'});
        charMap.put('3', new char[] {'d', 'e', 'f'});
        charMap.put('4', new char[] {'g', 'h', 'i'});
        charMap.put('5', new char[] {'j', 'k', 'l'});
        charMap.put('6', new char[] {'m', 'n', 'o'});
        charMap.put('7', new char[] {'p', 'q', 'r', 's'});
        charMap.put('8', new char[] {'t', 'u', 'v'});
        charMap.put('9', new char[] {'w', 'x', 'y', 'z'});

        recur(ret, new StringBuilder(), digits, 0, charMap);
        
        return ret;
    }
}
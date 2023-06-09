class Solution {
    public String restoreString(String s, int[] indices) {

        char[] charArr = new char[s.length()];

        for (int i = 0; i < indices.length; i++) {
            charArr[indices[i]] = s.charAt(i);
        }

        StringBuilder res = new StringBuilder();
        res.append(charArr);
        return new String(res);
    }
}
class Solution {
    public int lengthOfLastWord(String s) {
        String[] stringArr = s.split(" ");
        return stringArr[stringArr.length-1].length();
    }
}
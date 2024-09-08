class Solution {
    public String convertDateToBinary(String date) {
        String[] sArr = date.split("-", 0);

        String ret = "";

        for (String s : sArr) {
            ret = ret + Integer.toBinaryString(Integer.parseInt(s)) + "-";
        }

        return ret.substring(0, ret.length()-1);
    }
}
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String nString = Integer.toBinaryString(n);
        while (nString.length() < 32) {
            nString = "0" + nString;
        }

        char[] nArr = nString.toCharArray();

        for (int i = 0; i < nArr.length/2; i++) {
            char temp = nArr[i];
            nArr[i] = nArr[nArr.length-1-i];
            nArr[nArr.length-1-i] = temp;
        }

        long res = Long.parseLong(String.valueOf(nArr), 2);

        return (int)res;
    }
}
class Solution {
    public long numberOfWays(String s) {

        int[] zerosBefore = new int[s.length()];
        int[] onesBefore = new int[s.length()];
        int[] zerosAfter = new int[s.length()];
        int[] onesAfter = new int[s.length()];

        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            zerosBefore[i] = zeroCount;
            onesBefore[i] = oneCount;

            if (c == '0') {
                zeroCount++;
            }
            else {
                oneCount++;
            }
        }

        zeroCount = 0;
        oneCount = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);

            zerosAfter[i] = zeroCount; 
            onesAfter[i] = oneCount;

            if (c == '0') {
                zeroCount++;
            }
            else {
                oneCount++;
            }
        }

        long ret = 0;

        //can be 101 or 010
        //find number of ones before a zero and after that zero
        //find number of zeros before a one and after that one

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '0') {
                ret += onesBefore[i] * onesAfter[i];
            }
            else {
                ret += zerosBefore[i] * zerosAfter[i];
            }
        }

        return ret;
    }
}
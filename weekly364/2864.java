class Solution {
    public String maximumOddBinaryNumber(String s) {
        int oneCount = 0;
        int totalCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneCount++;
            }
            totalCount++;
        }
        String ret = "";
        
        while (oneCount > 1) {
            ret += "1";
            oneCount--;
            totalCount--;
        }
        
        while (totalCount > 1) {
            ret += "0";
            totalCount--;
        }
        
        ret += "1";
        
        return ret;
        
    }
}
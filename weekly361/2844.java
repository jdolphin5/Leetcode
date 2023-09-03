class Solution {
    public int minimumOperations(String num) {
        
        //00, 25, 50, or 75
        boolean zeroFound = false;
        boolean fiveFound = false;
        int ret = 0;
        
        for (int i = num.length()-1; i >= 0; i--) {
            int cur = Character.getNumericValue(num.charAt(i));
            if (zeroFound && cur == 0) {
                return num.length()-i-2;
            }
            else if (zeroFound && cur == 5) {
                return num.length()-i-2;
            }
            else if (fiveFound && cur == 7) {
                return num.length()-i-2;
            }
            else if (fiveFound && cur == 2) {
                return num.length()-i-2;
            }
            else if (cur == 0) {
                zeroFound = true;
            }
            else if (cur == 5) {
                fiveFound = true;
            }
        }
        
        return zeroFound ? num.length()-1 : num.length();
        
    }
}
class Solution {
    public long minimumCost(String s) {
        long minCost = Long.MAX_VALUE;
        
        //try all 1s
        int i = s.length()/2;
        int j = i+1;
        
        char curChar = '0';
        long cost = 0;
        
        while (i >= 0) {
            if (s.charAt(i) == curChar) {
                //toggle 0 to i
                if (curChar == '0') {
                    curChar = '1';
                }
                else {
                    curChar = '0';
                }
                cost += i+1;
                //System.out.println("i: " + i + " cost: " + cost);
            }
            i--;
        }
        
        curChar = '0';
        
        while (j < s.length()) {
            if (s.charAt(j) == curChar) {
                //toggle 0 to i
                if (curChar == '0') {
                    curChar = '1';
                }
                else {
                    curChar = '0';
                }
                cost += s.length()-j;
                //System.out.println("j: " + j + " cost: " + cost);
            }
            j++;
        }
        
        minCost = Math.min(cost, minCost);
        
        curChar = '1';
        cost = 0;
        i = s.length()/2;
        j = i+1;
        
        while (i >= 0) {
            if (s.charAt(i) == curChar) {
                //toggle 0 to i
                if (curChar == '0') {
                    curChar = '1';
                }
                else {
                    curChar = '0';
                }
                cost += i+1;
                //System.out.println("i: " + i + " cost: " + cost);
            }
            i--;
        }
        
        curChar = '1';
        
        while (j < s.length()) {
            if (s.charAt(j) == curChar) {
                //toggle 0 to i
                if (curChar == '0') {
                    curChar = '1';
                }
                else {
                    curChar = '0';
                }
                cost += s.length()-j;
                //System.out.println("j: " + j + " cost: " + cost);
            }
            j++;
        }
        
        
        minCost = Math.min(cost, minCost);
        
        
        
        return minCost;
        
        
        //try all 0s
        
        
    }
}
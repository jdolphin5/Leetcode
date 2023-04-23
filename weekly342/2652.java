package weekly342;
class Solution {
    
    private static boolean isDivisible(int x) {
        if (x % 3 == 0 || x % 5 == 0 || x % 7 == 0) {
            return true;
        }
        return false;
    }
    
    public int sumOfMultiples(int n) {
        int result = 0;
        
        for (int i = 1; i <= n; i++) {
            if (isDivisible(i)) {
                result += i;
            }
        }
        return result;
        
    }
}
class Solution {
    public boolean isFascinating(int n) {
        String nString = String.valueOf(n);
        String nString2 = String.valueOf(2*n);
        String nString3 = String.valueOf(3*n);
        
        String conc = nString + nString2 + nString3;
        
        int[] bucket = new int[10];
        for (int i = 0; i < conc.length(); i++) {
            bucket[Character.getNumericValue(conc.charAt(i))]++;
        }
        if (bucket[0] > 0) return false;
        
        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i] != 1) return false;
        }
        
        return true;
        
    }
}
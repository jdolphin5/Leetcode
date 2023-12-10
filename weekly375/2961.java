class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ret = new ArrayList<>();
        
        //A^B mod C = ( (A mod C)^B ) mod C
        
        //a = (ai^bi % 10)
        //b = ci
        //m = m
        
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int m = variables[i][3];
            
            int x = a;
            
            for (int j = 1; j < b; j++) {
                x = (x * a) % 10;
            }
            
            if (b == 1) {
                x = a % 10;
            }
            
            //System.out.println(x);
            
            int y = x;
            
            for (int k = 1; k < c; k++) {
                y = (y * x) % m;
            }
            
            if (c == 1) {
                y = x % m;
            }
            
            
            if (y == target) ret.add(i);
            
        }
        
        return ret;
    }
}
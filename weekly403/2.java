class Solution {
    public int minimumArea(int[][] grid) {
        int a = Integer.MAX_VALUE; //top
        int b = Integer.MAX_VALUE; //left
        int c = 0; //bottom
        int d = 0; //right
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    a = Math.min(a, i);
                    c = Math.max(c, i);
                    b = Math.min(b, j);
                    d = Math.max(d, j);
                }
            }
        }
        
        //System.out.println("a: " + a + " b: " + b + " c: " + c + " d: " + d);
        
        return (c + 1 - a) * (d + 1 - b);
    }
}
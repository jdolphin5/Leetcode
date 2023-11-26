class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int[][] matCopy = new int[mat.length][mat[0].length];
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i % 2 == 0) {
                    matCopy[i][(j-k+(50*mat[0].length))%mat[0].length] = mat[i][j]; 
                }
                else {
                    matCopy[i][(j+k+(mat[0].length))%mat[0].length] = mat[i][j]; 
                }
            }
        }
        
        //System.out.println(Arrays.toString(mat))
        
        return Arrays.deepEquals(mat, matCopy);
    }
}
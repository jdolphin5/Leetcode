class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ret = 0;
        double maxDiag = 0.0;
        
        for (int i = 0; i < dimensions.length; i++) {
            double diagonal = Math.sqrt((dimensions[i][0] * dimensions[i][0]) + (dimensions[i][1] * dimensions[i][1]));
            //System.out.println(diagonal);
            if (maxDiag < diagonal) {
                maxDiag = diagonal;
                ret = dimensions[i][0] * dimensions[i][1];
            }
            else if (maxDiag == diagonal) {
                if (ret < dimensions[i][0] * dimensions[i][1]) {
                    ret = dimensions[i][0] * dimensions[i][1];
                }
            }
        }
        
        return ret;
    }
}
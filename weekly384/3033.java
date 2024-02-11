class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[][] answer = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                answer[i][j] = matrix[i][j];
            }
        }
        
        int[] maxColNum = new int[matrix[0].length];
        
        Arrays.fill(maxColNum, -1);
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                answer[i][j] = matrix[i][j];
                maxColNum[j] = Math.max(maxColNum[j], matrix[i][j]);
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (answer[i][j] == -1)
                    answer[i][j] = maxColNum[j];
            }
        }
        
        return answer;
    }
}
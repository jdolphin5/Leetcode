class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int rowCount = 0;
        int maxRowCount = 0;
        int maxRowIndex = 0;
        
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    rowCount++;
                    lastOneIndex = j;
                }
            }
            if (maxRowCount < rowCount) {
                maxRowCount = rowCount;
                maxRowIndex = i;
            }
            rowCount = 0;
            lastOneIndex = 0;
            
            System.out.println(maxRowIndex);
            
        }
        return new int[] {maxRowIndex, maxRowCount};
    }
}
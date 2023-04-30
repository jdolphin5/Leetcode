class Solution {
    
    
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();     
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMap.put(mat[i][j], i);
                colMap.put(mat[i][j], j);
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            int x = rowMap.get(arr[i]);
            int y = colMap.get(arr[i]);
            rowCount[x]++;
            colCount[y]++;
            if (rowCount[x] == n || colCount[y] == m) return i;
        }

        
        return -1;
        
        /*
        if (mat[i][j] == x) {
            rowCount[i]++;
            colCount[j]++;
            if (rowCount[i] == n || colCount[j] == m) return true;
            return false;
        }
        */
    }
}
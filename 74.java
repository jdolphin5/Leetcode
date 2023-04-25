class Solution {

    private int searchMatrixRow(int[][] matrix, int target, int n, int lower, int upper) {

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (matrix[mid][0] <= target) {
                if (matrix[mid][n-1] >= target) {
                    return mid;
                }
                else {
                    lower = mid + 1;
                }
            }
            else {
                upper = upper - 1;
            }
        }
        return -1;
    }

    private int searchMatrixCol(int[][] matrix, int target, int lower, int upper, int row) {

        if (row == -1) return -1;

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (matrix[row][mid] == target) return mid;
            else if (matrix[row][mid] < target) {
                lower = mid + 1;
            }
            else {
                upper = upper - 1;
            }
        }
        return -1;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = -1;
        int col = -1;

        row = searchMatrixRow(matrix, target, n, 0, m);
        col = searchMatrixCol(matrix, target, 0, n, row);

        System.out.println(row);
        System.out.println(col);

        if (col == -1) return false;
        return true;
    }
}
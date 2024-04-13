class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] intMatrix = new int[matrix.length][matrix[0].length];
        int ret = 0;

        for (int i = 0; i < matrix.length; i++) {
            int cur = 0;

            for (int j = 0; j < matrix[0].length; j++) {
                cur += matrix[i][j]-'0';
                if (matrix[i][j] == '0') {
                    cur = 0;
                }

                intMatrix[i][j] = cur;
            }
        }

        //System.out.println(Arrays.deepToString(intMatrix));

        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (intMatrix[i][j] > 0) {
                    int x = i;
                    int cur = Integer.MAX_VALUE;
                    int ct = 0;
                    
                    while (x < matrix.length && intMatrix[x][j] != 0) {
                        ct++;
                        cur = Math.min(cur, intMatrix[x][j]);
                        ret = Math.max(ret, cur * ct);
                        x++;
                    }
                }
            }
        }

        return ret;
    }
}
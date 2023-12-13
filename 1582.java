class Solution {
    public int numSpecial(int[][] mat) {
        int ret = 0;

        int[] rowFound = new int[mat.length];
        int[] colFound = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    rowFound[i]++;
                    colFound[j]++;
                }
            }
        }

        System.out.println(Arrays.toString(rowFound));
        System.out.println(Arrays.toString(colFound));

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && rowFound[i] == 1 && colFound[j] == 1) {
                    //System.out.println("i: " + i + " J : " + j);
                    rowFound[i]--;
                    colFound[j]--;
                    ret++;
                }
            }

        }

        return ret;
    }
}
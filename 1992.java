class Solution {
    private void findCoordinates(int[][] land, int[] retArr, int i, int j) {
        if (i < 0 || j < 0 || i >= land.length || j >= land[0].length || land[i][j] != 1) {
            return;
        }

        land[i][j] = 0;

        retArr[2] = Math.max(retArr[2], i);
        retArr[3] = Math.max(retArr[3], j);

        findCoordinates(land, retArr, i-1, j);
        findCoordinates(land, retArr, i+1, j);
        findCoordinates(land, retArr, i, j-1);
        findCoordinates(land, retArr, i, j+1);
    }

    public int[][] findFarmland(int[][] land) {
        List<int[]> retList = new ArrayList<>();
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int[] retArr = new int[] {i, j, 0, 0};
                    findCoordinates(land, retArr, i, j);
                    retList.add(retArr);
                }
            }
        }

        int[][] ret = new int[retList.size()][4];
        int i = 0;
        
        for (int[] retArr : retList) {
            ret[i++] = retArr;
        }
        
        return ret;
    }
}
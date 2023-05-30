class Solution {

    private void setupPacific(int[][] heights, int[][] pacific, int m, int n) {
        // 0 signifies is not connected
        // 1 signifies is connected but not traversed adjacent
        // 2 signifies is connected and has traversed adjacent
        boolean needToTraverse = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pacific[i][j] = 1;
                }
            }
        }

        while(needToTraverse) {
            needToTraverse = false;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (pacific[i][j] == 1) {
                        needToTraverse = true;
                        pacific[i][j] = 2;
                        traverse(heights, pacific, m, n, i-1, j, heights[i][j]);
                        traverse(heights, pacific, m, n, i+1, j, heights[i][j]);
                        traverse(heights, pacific, m, n, i, j-1, heights[i][j]);
                        traverse(heights, pacific, m, n, i, j+1, heights[i][j]);
                    }
                }
            }
        }
    }

    private void setupAtlantic(int[][] heights, int[][] atlantic, int m, int n) {
        // 0 signifies is not connected
        // 1 signifies is connected but not traversed adjacent
        // 2 signifies is connected and has traversed adjacent
        boolean needToTraverse = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == m-1 || j == n-1) {
                    atlantic[i][j] = 1;
                }
            }
        }

        while(needToTraverse) {
            needToTraverse = false;
            for (int i = m-1; i >= 0; i--) {
                for (int j = n-1; j >= 0; j--) {
                    if (atlantic[i][j] == 1) {
                        needToTraverse = true;
                        atlantic[i][j] = 2;
                        traverse(heights, atlantic, m, n, i-1, j, heights[i][j]);
                        traverse(heights, atlantic, m, n, i+1, j, heights[i][j]);
                        traverse(heights, atlantic, m, n, i, j-1, heights[i][j]);
                        traverse(heights, atlantic, m, n, i, j+1, heights[i][j]);
                    }
                }
            }
        }
    }

    private void traverse(int[][] heights, int[][] myArray, int m, int n, int i, int j, int squareHeight) {
        if (i < 0 || j < 0 || i >= m || j >= n || myArray[i][j] == 2) return;
        if (squareHeight <= heights[i][j]) myArray[i][j] = 1;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;

        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];

        setupPacific(heights, pacific, m, n);
        setupAtlantic(heights, atlantic, m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] == 2 && atlantic[i][j] == 2) {
                    List<Integer> myList = new ArrayList<>();
                    myList.add(i);
                    myList.add(j);
                    result.add(myList);
                }
            }
        }

        return result;
    }
}
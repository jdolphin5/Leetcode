class Solution {

    private void changeCoordinates(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;

        if (x < 0 || y < 0 || x >= m || y >= n) {
            return;
        }
        
        if (grid[x][y] == 1) grid[x][y] = 2;

    }

    public int orangesRotting(int[][] grid) {
        List<int[]> rottenFoundList = new ArrayList<int[]>();
        int count = 0;
        boolean rottenFound = true; //assuming there is one 2 at least
        int m = grid.length;
        int n = grid[0].length;
        
        while (rottenFound) {
            rottenFound = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        rottenFound = true;
                        int[] coordinates = {i, j};
                        rottenFoundList.add(coordinates);
                    }
                }
            }
            if (rottenFound == true) count++;
            //change rotten 4-way surroundings to 2 if 1
            for (int a = 0; a < rottenFoundList.size(); a++) {
                int x = rottenFoundList.get(a)[0];
                int y = rottenFoundList.get(a)[1];
                changeCoordinates(grid, x-1, y);
                changeCoordinates(grid, x+1, y);
                changeCoordinates(grid, x, y-1);
                changeCoordinates(grid, x, y+1);
                grid[x][y] = 0;
            }
            rottenFoundList.clear();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return Math.max(0, count-1); //first run is minute 0 and need to return 0 if no 2s found (and no ones left)
    }
}
class Solution {
    
    private void addSetTop(int i, int j, Set<Integer> mySet, int m, int n, int[][] grid) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        mySet.add(grid[i][j]);
        addSetTop(i-1, j-1, mySet, m, n, grid);
    }
    
    private void addSetBot(int i, int j, Set<Integer> mySet, int m, int n, int[][] grid) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        mySet.add(grid[i][j]);
        addSetBot(i+1, j+1, mySet, m, n, grid);
    }
    
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] answer = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> topLeft = new HashSet<>();
                addSetTop(i-1, j-1, topLeft, m, n, grid);
                Set<Integer> botRight = new HashSet<>();
                addSetBot(i+1, j+1, botRight, m, n, grid);
                //System.out.println("i: " + i + " j: " + j + " top: " + topLeft.size() + " bot: " + botRight.size());
                //System.out.println(botRight.toString());
                answer[i][j] = Math.abs(topLeft.size() - botRight.size());
            }
        }
        
        return answer;
    }
    
}
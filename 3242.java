class neighborSum {

    int[][] globalGrid;
    Map<Integer, Integer> valueToRowMap;
    Map<Integer, Integer> valueToColMap;

    public neighborSum(int[][] grid) {
        globalGrid = grid;
        valueToRowMap = new HashMap<>();
        valueToColMap = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                valueToRowMap.put(grid[i][j], i);
                valueToColMap.put(grid[i][j], j);
            }
        }
    }
    
    public int adjacentSum(int value) {
        int i = valueToRowMap.get(value);
        int j = valueToColMap.get(value);

        int ret = 0;

        if (i >= 1)
            ret += globalGrid[i-1][j];
        if (i <= globalGrid.length-2)
            ret += globalGrid[i+1][j];
        if (j >= 1)
            ret += globalGrid[i][j-1];
        if (j <= globalGrid[0].length-2)
            ret += globalGrid[i][j+1];

        return ret;
    }
    
    public int diagonalSum(int value) {
        int i = valueToRowMap.get(value);
        int j = valueToColMap.get(value);

        int ret = 0;

        if (i >= 1 && j >= 1)
            ret += globalGrid[i-1][j - 1];
        if (i <= globalGrid.length-2 && j <= globalGrid[0].length-2)
            ret += globalGrid[i+1][j+1];
        if (i <= globalGrid[0].length-2 && j >= 1)
            ret += globalGrid[i+1][j-1];
        if (i >= 1 && j <= globalGrid[0].length-2)
            ret += globalGrid[i-1][j+1];

        return ret;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
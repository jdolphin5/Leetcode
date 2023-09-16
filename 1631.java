class Solution {
    private boolean dfs(int[][] heights, boolean[][] visited, int row, int col, int lastHeight, int threshold) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || visited[row][col] || Math.abs(heights[row][col] - lastHeight) > threshold) {
            return false;
        }

        visited[row][col] = true;

        return (
            (row == heights.length-1 && col == heights[0].length-1)
            || dfs(heights, visited, row+1, col, heights[row][col], threshold)
            || dfs(heights, visited, row-1, col, heights[row][col], threshold)
            || dfs(heights, visited, row, col+1, heights[row][col], threshold)
            || dfs(heights, visited, row, col-1, heights[row][col], threshold));
    }


    public int minimumEffortPath(int[][] heights) {
        int lower = 0;
        int upper = 1000000;

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (dfs(heights, new boolean[heights.length][heights[0].length], 0, 0, heights[0][0], mid)) {
                upper = mid;
            }
            else {
                lower = mid+1;
            }
        }

        return upper;
    }
}
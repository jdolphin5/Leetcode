class Solution {
    private boolean search(char[][] board, String word, int x, int i, int j, boolean[][] visited) {
        if (x == word.length()) return true;
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || word.charAt(x) != board[i][j])
            return false;

        visited[i][j] = true;

        boolean ret = search(board, word, x+1, i-1, j, visited) ||
        search(board, word, x+1, i+1, j, visited) ||
        search(board, word, x+1, i, j-1, visited) ||
        search(board, word, x+1, i, j+1, visited);

        visited[i][j] = false;

        return ret;

    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (search(board, word, 0, i, j, visited))
                    return true;
            }
        }

        return false;
    }
}
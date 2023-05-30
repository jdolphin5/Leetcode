class Solution {

    private void stayO(char[][] board, int i, int j, boolean[][] visited) {
        visited[i][j] = true;

        if (i-1 > 0 && i-1 < board.length && board[i-1][j] == 'O' && !visited[i-1][j])
            stayO(board, i-1, j, visited);
        if (i+1 > 0 && i+1 < board.length && board[i+1][j] == 'O' && !visited[i+1][j])
            stayO(board, i+1, j, visited);
        if (j-1 > 0 && j-1 < board[0].length && board[i][j-1] == 'O' && !visited[i][j-1])
            stayO(board, i, j-1, visited);
        if (j+1 > 0 && j+1 < board[0].length && board[i][j+1] == 'O' && !visited[i][j+1])
            stayO(board, i, j+1, visited);

    }

    public void solve(char[][] board) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            if (i == 0 || i == board.length-1) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'O') {
                        stayO(board, i, j, visited);
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (j == 0 || j == board[0].length-1) {
                    if (board[i][j] == 'O') {
                        stayO(board, i, j, visited);
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
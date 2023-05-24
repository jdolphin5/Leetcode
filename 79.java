class Solution {

    private boolean wordFound(char[][] board, String word, int curChar, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) return false;


        if (board[i][j] == word.charAt(curChar)) {
            //System.out.println("i: " + i + " j: " + j);
            visited[i][j] = true;
            curChar++;
            if (curChar == word.length()) return true;
            if (wordFound(board, word, curChar, i+1, j, visited) ||
                    wordFound(board, word, curChar, i-1, j, visited) ||
                    wordFound(board, word, curChar, i, j+1, visited) ||
                    wordFound(board, word, curChar, i, j-1, visited) )
                return true;
            visited[i][j] = false;
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (wordFound(board, word, 0, i, j, visited)) return true;
            }
        }
        return false;
    }
}
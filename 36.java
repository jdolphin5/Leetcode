class Solution {

    private boolean checkValid(List<Character> myList) {
        Set<Character> mySet = new HashSet<>();
        //System.out.println(myList.toString());
        for (Character c : myList) {
            if (mySet.contains(c) && c != '.') return false;
            mySet.add(c);
        }
        return true;
    }

    private List<Character> threeByThree(char[][] board, int iStart, int iEnd, int jStart, int jEnd) {
        List<Character> res = new ArrayList<>();
        for (int i = iStart; i <= iEnd; i++) {
            for (int j = jStart; j <= jEnd; j++) {
                res.add(board[i][j]);
            }
        }
        return res;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[] threeByThreeBool = new boolean[9];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                List<Character> threeByThreeList = threeByThree(board, i*3, i*3+2, j*3, j*3+2);
                threeByThreeBool[i*3+j] = checkValid(threeByThreeList);
            }
        }

        for (boolean bool : threeByThreeBool) {
            if (!bool) return false;
        }

        List<Character>[] rowLists = new List[9];
        List<Character>[] colLists = new List[9];

        for (int i = 0; i < rowLists.length; i++) {
            rowLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < colLists.length; i++) {
            colLists[i] = new ArrayList<>();
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                rowLists[i].add(board[i][j]);
                colLists[j].add(board[i][j]);
            }
        }

        for (int i = 0; i < rowLists.length; i++) {
            if (!checkValid(rowLists[i])) return false;
        }
        for (int i = 0; i < colLists.length; i++) {
            if (!checkValid(colLists[i])) return false;
        }


        return true;
        
    }
}
class Solution {
    public String alphabetBoardPath(String target) {
        //row == (target.charAt(i)-'a') / 5
        //col == (target.charAt(i)-'a') % 5 (0-indexed)
        StringBuilder ret = new StringBuilder();
        int startRow = 0, startCol = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int cur = c-'a';
            int destRow = cur / 5;
            int destCol = cur % 5;
            while ((startRow != destRow)) {
                if (startRow == 4 && c == 'z') {
                    break;
                }
                if (startRow < destRow) {
                    ret.append('D');
                    startRow++;
                }
                else {
                    ret.append('U');
                    startRow--;
                }
            }
            while (startCol != destCol) {
                if (startCol < destCol) {
                    ret.append('R');
                    startCol++;
                }
                else {
                    ret.append('L');
                    startCol--;
                }
            }
            if (startRow == 4 && destRow == 5) {
                ret.append('D');
                startRow++;
            }
            ret.append('!');
        }

        return ret.toString();
    }
}
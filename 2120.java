class Solution {

    private int dfs(int n, int index, int i, int j, String s) {
        //System.out.println("index:" + index + " i: " + i + " j: " + j);
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return -1;
        }
        
        if (index >= s.length()) return 0;

        /*
        if (s.charAt(index) == 'L')
            j--;
        else if (s.charAt(index) == 'R')
            j++;
        else if (s.charAt(index) == 'U')
            i--;
        else if (s.charAt(index) == 'D')
            i++;
        */

        switch(s.charAt(index)) {
            case 'L':
                j--;
                break;
            case 'R':
                j++;
                break;
            case 'U':
                i--;
                break;
            case 'D':
                i++;
                break;
            default:
        }

        return 1 + dfs(n, index+1, i, j, s);
    }

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            answer[i] = dfs(n, i, startPos[0], startPos[1], s);
        }
        return answer;
    }
}
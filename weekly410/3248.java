class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;

        for (String s : commands) {
            switch (s) {
                case "UP":
                    i--;
                    break;
                case "RIGHT":
                    j++;
                    break;
                case "DOWN":
                    i++;
                    break;
                case "LEFT":
                    j--;
                    break;
                default:

            }
        }

        return (i * n) + j;
    }
}
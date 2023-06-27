class Solution {
    public int countPoints(String rings) {
        int ret = 0;
        boolean[][] hasColouredRod = new boolean[10][3]; //10 rods, 3 colours
        for (int i = 0; i < rings.length(); i+=2) {
            char first = rings.charAt(i);
            char second = rings.charAt(i+1);
            int firstInt;
            int secondInt = Character.getNumericValue(second);
            if (first == 'R') {
                firstInt = 0;
            }
            else if (first == 'G') {
                firstInt = 1;
            }
            else {
                firstInt = 2;
            }
            hasColouredRod[secondInt][firstInt] = true;
        }
        for (int i = 0; i < hasColouredRod.length; i++) {
            if (hasColouredRod[i][0] && hasColouredRod[i][1] && hasColouredRod[i][2]) {
                ret++;
            }
        }
        return ret;
    }
}
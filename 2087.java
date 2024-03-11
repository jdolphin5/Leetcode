class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int i = startPos[0];
        int j = startPos[1];
        int cost = 0;

        while (i != homePos[0]) {
            if (i < homePos[0]) {
                cost += rowCosts[i+1];
                i++;
            }
            else if (i > homePos[0]) {
                cost += rowCosts[i-1];
                i--;
            }
        }

        while (j != homePos[1]) {
            if (j < homePos[1]) {
                cost += colCosts[j+1];
                j++;
            }
            else if (j > homePos[1]) {
                cost += colCosts[j-1];
                j--;
            }
        }

        return cost;
    }
}
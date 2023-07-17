class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] ret = new int[2];
        int curMaxNQual = 0;
        for (int x = 0; x <= 50; x++) {
            for (int y = 0; y <= 50; y++) {
                int nQual = 0;
                for (int i = 0; i < towers.length; i++) {
                    int towerX = towers[i][0];
                    int towerY = towers[i][1];
                    int towerQ = towers[i][2];
                    //d=√[(x2-x1)^2+(y2-y1)^2]
                    int d = (towerX-x) * (towerX-x) + (towerY-y) * (towerY-y);
                    if (d <= radius * radius)
                        nQual += towerQ / (1 + Math.sqrt(d));
                }
                if (nQual > curMaxNQual) {
                    curMaxNQual = nQual;
                    ret[0] = x;
                    ret[1] = y;
                }
            }
        }
        return ret;
    }
}
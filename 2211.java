class Solution {
    public int countCollisions(String directions) {
        int ret = 0;
        int movingRight = 0;
        int stationary = 0;
        boolean last = false;
        for (int i = 0; i < directions.length(); i++) {
            if (directions.charAt(i) == 'R') {
                movingRight++;
                last = true;
            }
            else if (directions.charAt(i) == 'S') {
                if (movingRight > 0) {
                    ret += movingRight;
                    movingRight = 0;
                }
                stationary++;
                last = false;
            }
            else {
                if (movingRight > 0 && last) {
                    ret += 2;
                    movingRight--;
                    ret += movingRight;
                    movingRight = 0;
                }
                else if (stationary > 0 && !last) {
                    ret++;
                    stationary--;
                }
                else {
                    if (ret > 0) {
                        ret++;
                    }
                }
            }
            //System.out.println(ret);
        }
        return ret;
    }
}
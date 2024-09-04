class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        //N, E, S, W
        final int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int i = 0;
        int j = 0;
        int dir = 0;

        Set<String> visited = new HashSet<>();

        for (int[] obs : obstacles) {
            visited.add(new String(obs[0] + " - " + obs[1]));
        }

        int ret = 0;

        for (int c : commands) {
            switch(c) {
                case -2:
                    dir = (dir-1 + 4) % 4;
                    break;
                case -1:
                    dir = (dir+1 + 4) % 4;
                    break;
                default:
                    int x = c;
                    while (x-- > 0) {
                        i += dirs[dir][0];
                        j += dirs[dir][1];

                        //if obstacle, go back to previous pos
                        if (visited.contains(new String(i + " - " + j))) {
                            i -= dirs[dir][0];
                            j -= dirs[dir][1];
                            break;
                        }
                    }
            }

            ret = Math.max(ret, (Math.abs(i)*Math.abs(i)) + (Math.abs(j)*Math.abs(j)));
        }

        return ret;
    }
}
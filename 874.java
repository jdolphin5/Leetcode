class Solution {

    private int turn(int direction, int turnDirection) {
        //0 is north, 1 is east, 2 is south, 3 is west
        if (turnDirection == 1) {
            //turn right
            switch (direction) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 3:
                    return 0;
            }
        }
        else if (turnDirection == 2) {
            //turn left
            switch (direction) {
                case 0:
                    return 3;
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 3:
                    return 2;
            }
        }
        return 0;
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Pair<Integer, Integer>> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            Pair<Integer, Integer> myPair = new Pair(obstacle[0], obstacle[1]);
            obstacleSet.add(myPair);
        }
        int direction = 0;
        int x = 0;
        int y = 0;
        int maxDistance = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                direction = turn(direction, 2); //turn left
            }
            else if (commands[i] == -1) {
                direction = turn(direction, 1); //turn right
            }
            else {
                for (int j = 1; j <= commands[i]; j++) {
                    if (direction == 0 && !obstacleSet.contains(new Pair(x, y+1))) {
                        y++;
                    }
                    else if (direction == 1 && !obstacleSet.contains(new Pair(x+1, y))) {
                        x++;
                    }
                    else if (direction == 2 && !obstacleSet.contains(new Pair(x, y-1))) {
                        y--; 
                    }
                    else if (direction == 3 && !obstacleSet.contains(new Pair(x-1, y))) {
                        x--;
                    }
                    else {
                        break;
                    }
                }
                //System.out.println("x: " + x + " y: " + y);
                maxDistance = Math.max(maxDistance, (x*x)+(y*y));

            }
        }
        return maxDistance;
        
    }
}
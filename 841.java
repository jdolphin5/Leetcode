class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        List<Integer> toVisit = new ArrayList<>();
        toVisit.add(0);

        while (toVisit.size() > 0) {
            List<Integer> nextVisit = new ArrayList<>();
            for (int toVisitRoom : toVisit) {
                if (!visited[toVisitRoom]) {
                    visited[toVisitRoom] = true;
                    for (int canVisitNext : rooms.get(toVisitRoom)) {
                        nextVisit.add(canVisitNext);
                    }
                }
            }
            toVisit = nextVisit;
        }

        for (boolean x : visited) {
            if (!x) {
                return false;
            }
        }

        return true;
    }
}
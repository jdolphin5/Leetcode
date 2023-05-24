class Solution {

    private boolean checkCycle(int i, Set<Integer> completed, Map<Integer, List<Integer>> myMap, Set<Integer> needed) {
        if (needed.contains(i)) { //cycle detected
            return false;
        }
        if (!myMap.containsKey(i)) { // no prereqs
            return true;
        }

        boolean ret = true;
        

        needed.add(i);
        List<Integer> myList = myMap.get(i);
        for (int course : myList) {
            if (!completed.contains(course)) {
                ret = checkCycle(course, completed, myMap, needed);
                if (!ret) return false;
            }
        }
        needed.remove(i);
        completed.add(i);

        return true;
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> completed = new HashSet<>();
        Map<Integer, List<Integer>> myMap = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int mustTake = prerequisites[i][1];
            myMap.putIfAbsent(course, new ArrayList<>());
            myMap.get(course).add(mustTake);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!completed.contains(i)) {
                if (!checkCycle(i, completed, myMap, new HashSet<>())) return false;
            }
        }

        return true;

    }
}
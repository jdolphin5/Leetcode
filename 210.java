class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    boolean[] explored;
    Stack<Integer> stack;

    private boolean isCyclic(int x) {
        visited[x] = true;
        for (Integer y : graph[x]) {
            if (!visited[y]) {
                if (isCyclic(y)) {
                    return true;
                }
            }
            else if (!explored[y]) {
                return true;
            }
        }
        explored[x] = true;
        return false;
    }

    private void topologicalSort(int x) {
        visited[x] = true;
        for (Integer y : graph[x]) {
            if (!visited[y]) {
                topologicalSort(y);
            }
        }
        stack.push(x);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        explored = new boolean[numCourses];
        visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if(isCyclic(i)) {
                    return new int[0];
                }
            }
        }

        visited = new boolean[numCourses];
        stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                topologicalSort(i);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }

        return result;

    }
}
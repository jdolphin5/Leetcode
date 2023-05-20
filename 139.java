class Solution {
    private boolean recur(String s, List<String> wordDict, Boolean[] visited, int i) {
        if (i == visited.length) return true;

        if (visited[i] != null) return visited[i];

        for (int k = i+1; k <= visited.length; k++) {
            if (wordDict.contains(s.substring(i, k)) && recur(s, wordDict, visited, k)) {
                return visited[i] = true;
            }
        }
        return visited[i] = false;

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] visited = new Boolean[s.length()]; //Boolean object to contain nulls initially

        return recur(s, wordDict, visited, 0);

    }
}
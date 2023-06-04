class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long res = 0;
        
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> rowSet = new HashSet<>();
        
        
        for (int i = queries.length-1; i >= 0; i--) {
            if (queries[i][0] == 0) {
                if (!colSet.contains(queries[i][1])) {
                    colSet.add(queries[i][1]);
                    res += (n-rowSet.size()) * queries[i][2];
                }
            }
            else if (queries[i][0] == 1) {
                if (!rowSet.contains(queries[i][1])) {
                    rowSet.add(queries[i][1]);
                    res += (n-colSet.size()) * queries[i][2];
                }
            }
        }
        return res;
    }
}
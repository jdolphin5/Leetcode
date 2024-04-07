class Solution {
    public class UnionFind {
        // data
        private int[] root;
        // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
        private int[] rank;
        private int[] minAndValue;
        
        public UnionFind(int n){
            this.root = new int[n];
            this.rank = new int[n]; // each rank is init to 1 since it points to itself
            this.minAndValue = new int[n];
            
            for(int i=0;i<n;i++){
                this.root[i] = i;
                this.rank[i] = 1;
                this.minAndValue[i] = Integer.MAX_VALUE;
            }
        }
        private void union(int x, int y, int wt){
            int rootX = find(x);
            int rootY = find(y);

            minAndValue[rootY] = minAndValue[rootX] & minAndValue[rootY] & wt;
            minAndValue[rootX] = minAndValue[rootX] & minAndValue[rootY] & wt;

            if(rootY == rootX){
                return;
            }
            
            if(rank[rootY] > rank[rootX]){
                root[rootX] = rootY;
            }
            else if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }
            else{
                root[rootY] = rootX;
                rank[rootY]++;
            }

            //System.out.println(Arrays.toString(minAndValue));
        }
        private int find(int x){
            if(root[x] == x){ // root
                return x;
            }
            return root[x] = find(root[x]);
        }
        private int getAndValueOfConnectedComponents(int root) {
            return minAndValue[root];
        }
    }
    
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] ret = new int[query.length];
        Arrays.fill(ret, Integer.MAX_VALUE);
        
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1], edge[2]);
        }

        int x = 0;
        for (int[] q : query) {
            if (q[0] == q[1]) {
                ret[x++] = 0;
            }
            else if (uf.find(q[0]) == uf.find(q[1])) {
                int minAndValue = uf.getAndValueOfConnectedComponents(uf.find(q[0]));
                ret[x++] = minAndValue;
            }
            else {
                ret[x++] = -1;
            }
        }

        return ret;
    }
}
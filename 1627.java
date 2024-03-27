class Solution {
    public class UnionFind {
        // data
        private int[] root;
        // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
        private int[] rank;
        
        public UnionFind(int n){
            this.root = new int[n];
            this.rank = new int[n]; // each rank is init to 1 since it points to itself
            
            for(int i=0;i<n;i++){
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }
        private void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            
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
        }
        private int find(int x){
            if(root[x] == x){ // root
                return x;
            }
            return root[x] = find(root[x]);
        }
        private boolean isConnected(int x, int y){
            return find(x) == find(y);
        }

        public String toString() {
            return Arrays.toString(root);
        }
    }

    private int gcd (int a, int b) {
        if (a % b == 0)
            return b;
        
        return gcd(b, a % b);
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> ret = new ArrayList<>();

        UnionFind uf = new UnionFind(n+1);

        for (int i = threshold+1; i <= n; i++) {
            for (int j = i*2; j <= n; j++) {
                if (gcd(i, j) > threshold) {
                    uf.union(i, j);
                    //System.out.println("i: " + i+ "  j: " + j);
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            if (uf.isConnected(queries[i][0], queries[i][1]))
                ret.add(true);
            else
                ret.add(false);
        }

        return ret;
    }
}
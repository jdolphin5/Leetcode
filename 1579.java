class Solution {
    public class UnionFind {
        // data
        private int[] root;
        // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
        private int[] rank;
        
        public UnionFind(int n){
            this.root = new int[n+1];
            this.rank = new int[n+1]; // each rank is init to 1 since it points to itself
            
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
    }

    private boolean checkUf(int n, UnionFind uf) {
        int parent = uf.find(1);

        for (int i = 2; i <= n; i++) {
            if (uf.find(i) != parent) return false;
        }

        return true;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind aliceUf = new UnionFind(n);
        UnionFind bobUf = new UnionFind(n);

        Arrays.sort(edges, (a, b) -> b[0] - a[0]);

        int ret = 0;

        for (int[] edge : edges) {
            int u = edge[1];
            int v = edge[2];
            
            if (edge[0] == 3) {
                if (aliceUf.isConnected(u, v)) {
                    ret++;
                }

                aliceUf.union(u, v);
                bobUf.union(u, v);
            }
            else if (edge[0] == 1) {
                if (aliceUf.isConnected(u, v)) {
                    ret++;
                }
                else {
                    aliceUf.union(u, v);
                }
            }
            else {
                if (bobUf.isConnected(u, v)) {
                    ret++;
                }
                else {
                    bobUf.union(u, v);
                }
            }
        }

        if (!checkUf(n, aliceUf) || !checkUf(n, bobUf)) {
            return -1;
        }

        return ret;
    }
}
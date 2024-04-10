class Solution {

    int ret = 0;

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
    private void union(int x, int y, int[] vals){
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootY == rootX){
            return;
        }
        
        if(vals[rootY] > vals[rootX]){
            root[rootX] = rootY;
        }
        else if(vals[rootX] > vals[rootY]){
            root[rootY] = rootX;
        }
        else{
            ret += rank[rootX] * rank[rootY];
            rank[rootX] += rank[rootY];
            root[rootY] = rootX;
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

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        UnionFind uf = new UnionFind(vals.length);

        ret += vals.length;

        Arrays.sort(edges, (a, b) -> Math.max(vals[a[0]], vals[a[1]]) - Math.max(vals[b[0]], vals[b[1]]));

        for (int[] edge : edges) {
            // union the two edges build the graph
            uf.union(edge[0], edge[1], vals);
        }

        return ret;
    }
}
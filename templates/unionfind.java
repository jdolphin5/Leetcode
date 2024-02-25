//in the main class:
UnionFind uf = new UnionFind(n);

//check if edges are connected
if(uf.isConnected(edge[0], edge[1])){
    continue;
}

// union the two edges build the graph
uf.union(edge[0], edge[1]);


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
}
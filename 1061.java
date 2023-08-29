class Solution {
    public class UnionFind {
        private int[] root;
        private int[] rank;
        
        public UnionFind(int n){
            this.root = new int[n];
            this.rank = new int[n];
            
            for(int i=0;i<n;i++){
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }
        public void union(int x, int y){
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
        public int find(int x){
            if(root[x] == x){ // root
                return x;
            }
            return root[x] = find(root[x]);
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind(26);

        for (int i = 0; i < s1.length(); i++) {
            uf.union(s1.charAt(i)-'a', s2.charAt(i)-'a');
        }

        Map<Integer, TreeSet<Integer>> myMap = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            int root = uf.find(i);
            TreeSet<Integer> myTreeSet = myMap.getOrDefault(root, new TreeSet<>());
            myTreeSet.add(i);
            myMap.put(root, myTreeSet);
        }

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < baseStr.length(); i++) {
            int c = baseStr.charAt(i)-'a';
            char a = 'a';
            int root = uf.find(c);
            int val = myMap.get(root).first(); //min value of TreeSet
            ret.append((char)(a + val));
        }

        return ret.toString();
    }
}
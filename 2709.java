class Solution {
    public class UnionFind {
        // data
        private int[] root;
        // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
        private int[] rank;
        
        public UnionFind(int n){
            this.root = new int[n];
            this.rank = new int[n]; // each rank is init to 1 since it points to itself
            
            for(int i=0; i < n; i++) {
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }
        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if(rootY == rootX){
                return;
            }
            
            if(rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            }
            else if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            }
            else{
                root[rootY] = rootX;
                rank[rootY]++;
            }
        }
        private int find(int x) {
            if(root[x] == x){ // root
                return x;
            }
            return root[x] = find(root[x]);
        }
        private boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }

    private Set<Integer> getPrimeFactors(Map<Integer, Set<Integer>> memo, int num) {
        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        Set<Integer> ret = new HashSet<>();

        // Print the number of 2s that divide n
        while (num % 2 == 0) {
            ret.add(2);
            num /= 2;
        }
 
        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            // While i divides n, print i and divide n
            while (num % i == 0) {
                ret.add(i);
                num /= i;
            }
        }
 
        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (num > 2)
            ret.add(num);

        memo.put(num, ret);

        return ret;
    }

    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) return true;

        UnionFind uf = new UnionFind(200001);
        Map<Integer, Set<Integer>> memo = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                return false;
            }
            Set<Integer> factors = getPrimeFactors(memo, nums[i]);
            //System.out.println(factors.toString());

            for (int factor : factors) {
                uf.union(i, factor+100000);
            }
        }

        Set<Integer> components = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            components.add(uf.find(i));
        }

        //System.out.println(components.toString());

        return components.size() == 1;
    }
}


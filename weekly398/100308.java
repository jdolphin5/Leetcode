class Solution {
    public class Pair {
        int i;
        int j;
        
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
        
        public String toString() {
            return new String("i: " + i + " j: " + j);
        }
    }
    
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        List<Pair> pairList = new ArrayList<>();
        
        int i = 0;
        int j = 1;
        
        boolean toAdd = false;
        
        while (i < nums.length) {
            if (j < nums.length && nums[j-1] % 2 != nums[j] % 2) {
                toAdd = true;
                j++;
            }
            else {
                if (toAdd)
                    pairList.add(new Pair(i, j-1));
                i = j;
                toAdd = false;
                j++;
            }
        }
        
        TreeMap<Integer, Pair> myTreeMap = new TreeMap<>();
        
        for (Pair p : pairList) {
            myTreeMap.put(p.i, p);
        }
        
        boolean[] answer = new boolean[queries.length];
        int x = 0;
        
        for (int[] q : queries) {
            int a = q[0];
            int b = q[1];
            
            if (a == b) {
                answer[x] = true;
                x++;
                continue;
            }
            
            Map.Entry<Integer, Pair> entry = myTreeMap.floorEntry(a);
            if (entry == null) {
                x++;
                continue;
            }
            int lower = entry.getKey();
            int upper = entry.getValue().j;
            
            if (upper >= b) answer[x] = true;
            
            x++;
        }
        
        //for (Pair p : pairList) {
        //    System.out.println(p);
        //}
        
        return answer;
    }
}
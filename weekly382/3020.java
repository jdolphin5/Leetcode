class Solution {
    public class Pair {
        int count;
        boolean visited;
        
        public Pair(int count) {
            this.count = count;
            this.visited = false;
        }
    }
    
    public int maximumLength(int[] nums) {
        Map<Integer, Pair> myMap = new HashMap<>();
        int ret = 1;
        
        Arrays.sort(nums);
        
        for (int num : nums) {
            Pair p = myMap.getOrDefault(num, new Pair(0));
            p.count++;
            myMap.put(num, p);
        }
        
        int oneCount = myMap.getOrDefault(1, new Pair(0)).count;
        
        ret = Math.max(ret, oneCount % 2 == 0 ? oneCount - 1 : oneCount);
        
        for (int num : nums) {
            if (myMap.get(num).visited) {
                continue;
            }
            
            int number = num;
            int ct = 0;
            
            while (myMap.containsKey(number) && !myMap.get(number).visited) {
                
                Pair p = myMap.get(number);
                //System.out.println("num: " + number + " p.ct: " + p.count);
                ct += Math.min(p.count, 2);
                p.visited = true;
                myMap.put(number, p);
                if (p.count >= 2 && number > 1 && number <= 32000) {
                    number = number * number;
                }
            }
            
            ret = Math.max(ret, ct % 2 == 0 ? ct-1 : ct);
            
        }
        
        return ret;
        
    }
}
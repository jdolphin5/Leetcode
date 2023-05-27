class Solution {
    public long maxStrength(int[] nums) {
        int temp = Integer.MIN_VALUE;
        boolean even = true;
        long prod = 1;
        boolean zero = false;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int num : nums) {
            if (num < 0) {
                pq.offer(num);
            }
            else if (num > 0) {
                queue.offer(num);
            }
            else {
                zero = true;
                continue;
            }
            
        }
        
        int x = queue.size();
        while (!queue.isEmpty()) {
            prod = prod * queue.poll();
        }
        if (pq.size() % 2 == 0 || (x < 1 && pq.size() < 2)) {
            while (!pq.isEmpty()) {
                prod *= pq.poll();
            }
        }
        else {
            int size = pq.size()-1;
            for (int i = 0; i < size; i++) {
                prod *= pq.poll();
            }
        }
        
        if (prod <= 1 && x < 1) {
            if (zero) {
                prod *= 0;
            }
        }
        
            
        
        
        return prod;
        
    }
}
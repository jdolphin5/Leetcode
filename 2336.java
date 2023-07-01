class SmallestInfiniteSet {

    int minPos = 1;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public SmallestInfiniteSet() {
        
    }
    
    public int popSmallest() {
        if (!pq.isEmpty()) return pq.poll();
        return minPos++;

    }
    
    public void addBack(int num) {
        if (num < minPos && !pq.contains(num)) {
            pq.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
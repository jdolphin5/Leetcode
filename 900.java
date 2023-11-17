class RLEIterator {
    PriorityQueue<Values> pq;

    public class Values {
        int value;
        int count;
        int i;

        public Values(int value, int count, int i) {
            this.value = value;
            this.count = count;
            this.i = i;
        }
    }

    public RLEIterator(int[] encoding) {
        pq = new PriorityQueue<>((a, b) -> a.i - b.i);

        for (int i = 0; i < encoding.length; i += 2) {
            if (encoding[i] == 0) continue;
            Values value = new Values(encoding[i+1], encoding[i], i);
            pq.offer(value);
        }
    }
    
    public int next(int n) {
        if (pq.isEmpty()) return -1;

        Values value = pq.peek();

        if (value.count < n) {
            int rem = n - value.count;
            pq.poll();
            return next(rem);
        }
        else { //if (value.count >= n)
            pq.poll();
            if (value.count != n) {
                pq.offer(new Values(value.value, value.count-n, value.i));
            }
            return value.value;
        }
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */
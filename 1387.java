class Solution {

    private int getPow(int cur) {
        if (cur == 1) return 0;

        if (cur % 2 == 0) {
            return 1 + getPow(cur / 2);
        }
        else {
            return 1 + getPow((cur * 3) + 1);
        }
    }


    public int getKth(int lo, int hi, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue()*1000 - b.getValue()*1000 + a.getKey() - b.getKey());

        for (int i = lo; i <= hi; i++) {
            Pair<Integer, Integer> myPair = new Pair<>(i, getPow(i));
            pq.offer(myPair);
        }

        Pair<Integer, Integer> myPair = new Pair<>(0,0);
        while (k > 0) {
            myPair = pq.poll();
            k--;
        }

        return myPair.getKey();
    }
}
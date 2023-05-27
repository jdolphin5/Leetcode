class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>
        (Comparator.comparing(Pair::getValue, (s1, s2) -> { return s2 - s1; }));
        int[] bucket = new int[200001];

        for (int num : nums) {
            bucket[100000+num]++;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) {
                Pair p = new Pair(i, bucket[i]);
                //System.out.println("i: " + i + " bucket[i]: " + bucket[i]);
                pq.add(p);
            }
        }

        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();
            res[i] = (int)p.getKey();
            res[i] -= 100000;
        }

        return res;


    }
}
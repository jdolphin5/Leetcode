class Solution {
    public int minDeletions(String s) {
        int ret = 0;
        int[] bucket = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            bucket[c-'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : bucket) {
            if (num > 0) {
                pq.offer(num);
            }
        }
        int last = 0;
        while (!pq.isEmpty()) {
            int cur = (int)pq.poll();
            if (cur == last) {
                ret++;
                if (cur > 1)
                    pq.offer(cur-1);
            }
            else {
                last = cur;
            }
        }

        return ret;
    }
}
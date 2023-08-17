class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());

        pq.offer(new Pair('a', a));
        pq.offer(new Pair('b', b));
        pq.offer(new Pair('c', c));

        StringBuilder ret = new StringBuilder();
        char last = 'd';

        while (!pq.isEmpty()) {
            Pair<Character, Integer> lastPair = new Pair('d', 0);
            Pair<Character, Integer> cur = pq.poll();
            int curValue = cur.getValue();
            char curKey = cur.getKey();
            if (curKey == last) {
                lastPair = cur;
                cur = pq.poll();
                last = cur.getKey();
                if (cur.getValue() >= 1) {
                    ret.append(last);
                    cur = new Pair(last, cur.getValue()-1);
                    pq.offer(cur);
                    pq.offer(lastPair);
                }
                else {
                    break;
                }
            }
            else {
                if (curValue > 1) {
                    ret.append(curKey);
                    ret.append(curKey);
                    pq.offer(new Pair(curKey, curValue-2));
                }
                else if (curValue > 0) {
                    ret.append(curKey);
                    pq.offer(new Pair(curKey, curValue-1));
                }
                last = curKey;
            }
        }

        return new String(ret);
    }
}
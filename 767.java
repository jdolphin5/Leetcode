class Solution {
    public String reorganizeString(String s) {
        StringBuilder ret = new StringBuilder();
        int[] bucket = new int[26];
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) {
                pq.offer(new Pair((char)('a'+i), bucket[i]));
            }
        }

        char last = '?';

        while (!pq.isEmpty()) {
            Pair<Character, Integer> myPair = pq.poll();
            char key = myPair.getKey();
            int val = myPair.getValue();

            if (key == last) {
                if (pq.isEmpty()) {
                    return "";
                }

                Pair<Character, Integer> myPair2 = pq.poll();
                char key2 = myPair2.getKey();
                int val2 = myPair2.getValue();

                ret.append(key2);

                if (val2-1 > 0)
                    pq.offer(new Pair(key2, val2-1));
                pq.offer(new Pair(key, val));
                last = key2;
            }
            else {
                ret.append(key);

                if (val-1 > 0)
                    pq.offer(new Pair(key, val-1));

                last = key;
            }
        }
        
        return new String(ret);
    }
}
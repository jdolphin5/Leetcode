class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        LinkedHashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();
        List<String> result = new ArrayList<String>();
        

        for (int i = 0; i < words.length; i++) {
            hm.put(words[i], hm.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<String>((a, b) -> hm.get(a).equals(hm.get(b)) ? 
        b.compareTo(a) : hm.get(a) - hm.get(b));

        for (String word: hm.keySet()) {
            queue.add(word);
            if (queue.size() > k) queue.poll();
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
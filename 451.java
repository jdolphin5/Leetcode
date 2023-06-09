class Solution {
    public String frequencySort(String s) {
        int[] bucket = new int[123]; //0-9 + 'A'-'z'
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i)]++;
        }

        PriorityQueue<Pair<Integer, Integer>> pq = 
        new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
          
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) {
                pq.add(new Pair<>(i, bucket[i]));
            }
        }
        
        //poll pq and add char pair-key repeated pair-value times
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> myPair = pq.poll();
            String myString = "" + (char)myPair.getKey().intValue();
            myString = myString.repeat(myPair.getValue());
            res.append(myString);
        }

        return new String(res);

    }
}
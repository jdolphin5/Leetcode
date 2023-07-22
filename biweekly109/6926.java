class Solution {
    public String sortVowels(String s) {
        Set<Character> mySet = new HashSet<>();
        
        mySet.add('a');
        mySet.add('e');
        mySet.add('i');
        mySet.add('o');
        mySet.add('u');
        mySet.add('A');
        mySet.add('E');
        mySet.add('I');
        mySet.add('O');
        mySet.add('U');
        
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mySet.contains(c)) {
                pq.offer(c);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mySet.contains(c)) {
                res.append(pq.poll());
            }
            else {
                res.append(c);
            }
        }
        return new String(res);
        
    }
}
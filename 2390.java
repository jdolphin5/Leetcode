class Solution {
    public String removeStars(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '*') {
                deque.removeLast();
            }
            else {
                deque.addLast(c);
            }
            i++;
        }

        while (!deque.isEmpty()) {
            res.append(deque.pollFirst());
        }
        return new String(res);
    }
}
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> myStack = new Stack<>();
        Set<Character> seenSet = new HashSet<>();
        Map<Character, Integer> lastOccurrenceMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastOccurrenceMap.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seenSet.contains(c)) {
                //if character not seen yet, add it to the stack
                //if the stack is not empty AND the top element (of the stack) is lexicographically greater than s.charAt(i)
                //AND the top element of the stack occurs later in the string
                //then: pop the top element and remove it from the seen set
                while (!myStack.isEmpty() && c < myStack.peek() && i < lastOccurrenceMap.get(myStack.peek())) {
                    seenSet.remove(myStack.pop());
                }

                seenSet.add(c);
                myStack.push(c);
            }
        }

        StringBuilder ret = new StringBuilder();
        
        while (!myStack.isEmpty()) {
            ret.append(myStack.pop());
        }

        ret.reverse();

        return new String(ret);
    }
}
class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> removeSet = new HashSet<>();
        Stack<Integer> myStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                myStack.push(i);
            }
            else if (c == ')') {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                }
                else {
                    removeSet.add(i);
                }
            }
        }

        while (!myStack.isEmpty()) {
            removeSet.add(myStack.pop());
        }

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!removeSet.contains(i))
                ret.append(s.charAt(i));
        }

        return new String(ret);
    }
}
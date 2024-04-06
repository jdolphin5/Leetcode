class Solution {
    public String minRemoveToMakeValid(String s) {
        boolean[] invalidCharArr = new boolean[s.length()];
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
                    invalidCharArr[i] = true;
                }
            }
        }

        while (!myStack.isEmpty()) {
            invalidCharArr[myStack.pop()] = true;
        }

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!invalidCharArr[i])
                ret.append(s.charAt(i));
        }

        return new String(ret);
    }
}
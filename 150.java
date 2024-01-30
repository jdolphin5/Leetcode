class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> myStack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                int a = myStack.pop();
                int b = myStack.pop();
                myStack.push(a+b);
            }
            else if (s.equals("-")) {
                int a = myStack.pop();
                int b = myStack.pop();
                myStack.push(b-a);
            }
            else if (s.equals("*")) {
                int a = myStack.pop();
                int b = myStack.pop();
                myStack.push(a*b);
            }
            else if (s.equals("/")) {
                int a = myStack.pop();
                int b = myStack.pop();
                myStack.push(b/a);
            }
            else {
                myStack.push(Integer.parseInt(s));
            }
        }

        return myStack.pop();
    }
}
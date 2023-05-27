class Solution {

    private boolean check(char x, char y) {
        if (x == '(' && y == ')') return true;
        else if (x == '{' && y == '}') return true;
        else if (x == '[' && y == ']') return true;

        return false;
    }

    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                myStack.push(s.charAt(i));
            else {
                if (!myStack.isEmpty()) {
                    char x = myStack.pop();
                    if (!check(x, s.charAt(i))) return false;
                }
                else {
                    return false;
                }
                
            } 
                
        }

        return myStack.isEmpty();
    }
}
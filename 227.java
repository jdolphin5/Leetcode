class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        char op = '+'; //just add first value to stack
        char[] c = s.toCharArray();
        
        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])) {
                curr = curr * 10 + c[i]-'0';
            }
            if ( (!Character.isDigit(c[i]) && c[i] != ' ') || i == c.length-1) {
                if (op == '+') stack.push(curr);
                else if (op == '-') stack.push(-curr);
                else if (op == '*') stack.push(stack.pop()*curr);
                else if (op == '/') stack.push(stack.pop()/curr);
                op = c[i];
                curr = 0;
            }
        }

        int sum = 0;
        while(!stack.isEmpty())
            sum += stack.pop();
        return sum;
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {

            char[] cArr = s.toCharArray();
            boolean isNumeric = true;
            for (int i = 0; i < cArr.length; i++) {
                if (!Character.isDigit(cArr[i])) {
                    if (i == 0 && cArr.length > 1) {
                        break;
                    }
                    isNumeric = false;
                    break;
                }
            }

            if (isNumeric) {
                Integer x = Integer.parseInt(s);
                stack.push(x);
            }
            else {
                if (stack.size() < 2) return 0;
                if (s.equals("+") || s.equals("-")) {
                    int a = stack.pop();
                    if (s.equals("-")) 
                        a = a * -1;
                    int b = stack.pop();
                    int sum = a + b;
                    stack.push(sum);
                }
                else if (s.equals("*")) {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(a*b);
                }
                else if (s.equals("/")) {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b/a);
                }
            }

        }

        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return 0;

    }
}
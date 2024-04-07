class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '(':
                    leftStack.push(i);
                    break;
                case '*':
                    asteriskStack.push(i);
                    break;
                case ')':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    else if (!asteriskStack.isEmpty()) {
                        asteriskStack.pop();
                    }
                    else {
                        return false;
                    }
                    break;
            }
        }

        if (asteriskStack.size() < leftStack.size())
            return false;

        while (leftStack.size() > 0) {
            if (asteriskStack.pop() < leftStack.pop()) {
                return false;
            }
        }

        return true;
    }
}
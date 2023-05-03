class MyQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {

    }
    
    public void push(int x) {
        if (stack1.isEmpty()) {
            stack1.push(x);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
    
    public int pop() {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
        int result = stack1.pop();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return result;
    }
    
    public int peek() {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
        int result = stack1.peek();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return result;
    }
    
    public boolean empty() {
        return stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class CustomStack {

    int[] stack;
    int curSize;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        curSize = 0;
    }
    
    public void push(int x) {
        if (curSize < stack.length) {
            for (int i = stack.length-1; i >= 1; i--) {
                stack[i] = stack[i-1];
            }

            stack[0] = x;
            curSize++;
        }
    }
    
    public int pop() {
        if (curSize == 0) return -1;
        int ret = stack[0];

        for (int i = 0; i < stack.length-1; i++) {
            stack[i] = stack[i+1];
        }
        
        curSize--;
        return ret;
    }
    
    public void increment(int k, int val) {
        int l = k < curSize ? curSize-k : 0;

        for (int i = l; i < Math.min(k+l, stack.length); i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
class Solution {
    public class Hill {
        int height;
        int index;

        public Hill (int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public int trap(int[] height) {
        Stack<Hill> myStack = new Stack<>();
        int ret = 0;
        int offset = 0;

        for (int i = 0; i < height.length; i++) {
            int cur = height[i];

            while (!myStack.isEmpty() && myStack.peek().height <= cur) {
                Hill h = myStack.pop();
                ret += (h.height - offset) * (i - h.index - 1);
                offset = h.height;
            }

            if (!myStack.isEmpty()) {
                Hill h = myStack.peek();
                ret += (cur - offset) * (i - h.index - 1);
            }

            if (myStack.isEmpty()) {
                offset = 0;
            }
            
            myStack.push(new Hill(cur, i));
        }

        return ret;
    }
}
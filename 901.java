class StockSpanner {
    public class Pair {
        int x;
        int span;

        public Pair(int x, int span) {
            this.x = x;
            this.span = span;
        }
    }


    Stack<Pair> myStack;

    public StockSpanner() {
        myStack = new Stack<>();
    }
    
    public int next(int price) {
        int ret = 1;

        while (!myStack.isEmpty() && myStack.peek().x <= price) {
            Pair p = myStack.pop();
            ret += p.span;
        }

        myStack.push(new Pair(price, ret));

        return ret;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
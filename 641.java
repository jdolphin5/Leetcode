class MyCircularDeque {

    List<Integer> deque;
    Integer max;

    public MyCircularDeque(int k) {
        this.deque = new ArrayList<>();
        this.max = k;
    }
    
    public boolean insertFront(int value) {
        if (deque.size() < max) {
            deque.add(0, value);
            return true;
        }

        return false;
    }
    
    public boolean insertLast(int value) {
        if (deque.size() < max) {
            deque.add(value);
            return true;
        }

        return false;
    }
    
    public boolean deleteFront() {
        if (deque.size() > 0) {
            deque.remove(0);
            return true;
        }

        return false;
    }
    
    public boolean deleteLast() {
        if (deque.size() > 0) {
            deque.remove(deque.size()-1);
            return true;
        }

        return false;
    }
    
    public int getFront() {
        if (deque.size() > 0)
            return deque.get(0);

        return -1;
    }
    
    public int getRear() {
        if (deque.size() > 0)
            return deque.get(deque.size()-1);
        return -1;
    }
    
    public boolean isEmpty() {
        return deque.size() == 0;
    }
    
    public boolean isFull() {
        return deque.size() == max;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
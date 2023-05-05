class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> myStack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (myStack.isEmpty() || asteroids[i] > 0 ) {
                myStack.push(asteroids[i]); //push positive asteroids on (going to right)
            }
            else { //if asteroid value is negative:
                while(true) {
                    int peek = myStack.peek();
                    if (peek < 0) {
                        myStack.push(asteroids[i]);
                        break;
                    }
                    else if (peek == -asteroids[i]) {
                        myStack.pop();
                        break;
                    }
                    else if (peek > -asteroids[i]) {
                        break;
                    }
                    else {
                        myStack.pop();
                        if (myStack.isEmpty()) {
                            myStack.push(asteroids[i]);
                            break;
                        }
                    }
                }
                
            }
        }

        int[] result = new int[myStack.size()];
        for (int i = myStack.size()-1; i >= 0; i--){
            result[i] = myStack.pop();
        }

    return result;
    }
}